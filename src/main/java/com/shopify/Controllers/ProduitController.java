package com.shopify.Controllers;

import com.shopify.Models.Boutique;
import com.shopify.Models.Produit;
import com.shopify.Responses.BoutiqueResponse;
import com.shopify.Responses.LoginResponse;
import com.shopify.Responses.ProduitResponse;
import com.shopify.Responses.SearchProduitResponse;
import com.shopify.Services.BoutiqueService;
import com.shopify.Services.PersonneService;
import com.shopify.Services.ProduitService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@RestController
@CrossOrigin
public class ProduitController {

    final PersonneService personneService;
    final BoutiqueService boutiqueService;
    final ProduitService produitService;


    public ProduitController(PersonneService personneService, BoutiqueService boutiqueService, ProduitService produitService) {
        this.personneService = personneService;
        this.boutiqueService = boutiqueService;
        this.produitService = produitService;
    }

    @PostMapping(path = "ajouter_produit")
    public ProduitResponse ajouterProduit(
            @RequestParam("nom") String nom,
            @RequestParam("categorie") String categorie,
            @RequestParam("prix") Long prix,
            @RequestParam("description") String description,
            @RequestParam("image") String image,
            @RequestParam("id_boutique") Long id_boutique
    ){

        // champs vide
        if(nom.isEmpty() || prix == null || image.isEmpty() || categorie.isEmpty()){
            return new ProduitResponse("Veuillez remplir tous les champs", "Bad Request");
        }

        Produit produit = new Produit(nom, categorie, prix, description, image, id_boutique, new Date());

        Produit registeredProduit = produitService.save(produit);

        return new ProduitResponse("Produit crée", "Request Ok", registeredProduit);

    }


    // My Produit
    @GetMapping(path = "/my_produit")
    public ProduitResponse myProduit(@RequestParam("produitId") Long produitId){

        Produit produit = produitService.findProduitById(produitId);


        if (produit != null) {
            return new ProduitResponse("Produit trouvé", "Request Ok", produit);
        }

        return new ProduitResponse("Produit non trouvé", "Bad Request");
    }

    @GetMapping(path = "/search")
    public SearchProduitResponse searchProduits(@RequestParam("query") String query){
        ArrayList<Produit> produits = produitService.searchProduits(query);

        return new SearchProduitResponse("Recherche success", "Request Ok", produits);
    }




}
