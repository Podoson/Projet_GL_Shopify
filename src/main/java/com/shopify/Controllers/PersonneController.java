package com.shopify.Controllers;

import com.shopify.Models.Boutique;
import com.shopify.Models.Panier;
import com.shopify.Models.Personne;
import com.shopify.Models.Produit;
import com.shopify.Responses.HomeResponse;
import com.shopify.Responses.LoginResponse;
import com.shopify.Responses.ProfileResponse;
import com.shopify.Services.BoutiqueService;
import com.shopify.Services.PanierService;
import com.shopify.Services.PersonneService;
import com.shopify.Services.ProduitService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@RestController
@CrossOrigin
public class PersonneController {
    final PersonneService personneService;
    final BoutiqueService boutiqueService;
    final ProduitService produitService;
    final PanierService panierService;

    public PersonneController(PersonneService personneService, BoutiqueService boutiqueService, ProduitService produitService, PanierService panierService) {
        this.personneService = personneService;
        this.boutiqueService = boutiqueService;
        this.produitService = produitService;
        this.panierService = panierService;
    }


    // Register
    @PostMapping(path = "/register")
    public LoginResponse register(@RequestParam("nom") String nom,
                         @RequestParam("prenom") String prenom,
                         @RequestParam("email") String email,
                         @RequestParam("password") String password,
                         @RequestParam("confirmPassword") String confirmPassword
    ){

        // champs vide
        if(nom.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()){
            return new LoginResponse("Veuillez remplir tous les champs", "Bad Request");
        }

        // password confirm
        if (!validatePasswordConf(password, confirmPassword)){
            return new LoginResponse("Mot de passe et confirmation ne sont pas bons", "Bad Request");
        }

        Personne principal = personneService.findPrincipal(email);

        //if account exist
        if (principal!= null){
            return new LoginResponse("Il existe un compte avec cette email", "Bad Request");
        }

        Personne personne = new Personne(nom, prenom, email, password, new Date());

        Personne registeredPersonne = personneService.save(personne);



        return new LoginResponse("Compte crée", "Request Ok", registeredPersonne);

    }

    //////////  Login
    @GetMapping(path = "/login")
    public LoginResponse login(@RequestParam("email") String email,
                               @RequestParam("password") String password){

        // if email and password empty
        if(email.isEmpty() || password.isEmpty()){
            return new LoginResponse("Veuillez remplir tous les champs", "Bad Request");
        }

        Personne principal = personneService.findPrincipal(email);

        //if account doesn't exist
        if (principal == null){
            return new LoginResponse("Aucun compte avec cet email n'est trouvé", "Bad Request");
        }

        if (!password.equals(principal.getPassword())){
            return new LoginResponse("Email ou mot de pass incorrect", "Bad Request");
        }
        else {
            LoginResponse loginResponse = new LoginResponse("Bien Venu", "Request Ok", principal);
            return loginResponse;
        }
    }

    @GetMapping(path = "/profile")
    public ProfileResponse profile(@RequestParam("principalId") Long principalId){

        // get the principal
        Personne principal = personneService.findById(principalId);

        // principal dosn't exist
        if (principal == null){
            return new ProfileResponse("Erreur Personne absent", "Bad Request");
        }else{
            // set principal profile
            ProfileResponse profileResponse = new ProfileResponse("Profile Succes", "Request Ok");
            profileResponse.setPrincipal(principal);

            // set boutique profile
            ArrayList<Boutique> boutiques = boutiqueService.findMyBoutiques(principalId);
            profileResponse.setBoutiques(boutiques);

            /// get paniers
            ArrayList<Panier> paniers = panierService.findMyPaniers(principalId);

            if (!paniers.isEmpty()) {
                ArrayList<Long> produitsIds = new ArrayList<>();

                for (Panier panier : paniers) {
                    produitsIds.add(panier.getIdProduit());
                }

                // get produits of panier
                ArrayList<Produit> produits = produitService.findMyPanierProduits(produitsIds);
                profileResponse.setProduits(produits);
            }

            return profileResponse;
        }

    }

    @GetMapping(path = "/")
    public HomeResponse home(){

        ArrayList<Produit> produits = produitService.findProduitsRandom();

        return new HomeResponse("Welcome Home", "Request Ok", produits);
    }





















    private boolean validatePasswordConf(String password, String confirmPass){
        return password.equals(confirmPass);
    }

















}
