package com.shopify.Controllers;

import com.shopify.Models.Boutique;
import com.shopify.Models.Produit;
import com.shopify.Responses.BoutiqueResponse;
import com.shopify.Responses.LoginResponse;
import com.shopify.Services.BoutiqueService;
import com.shopify.Services.PersonneService;
import com.shopify.Services.ProduitService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

@RestController
@CrossOrigin
public class BoutiqueController {
    final PersonneService personneService;
    final BoutiqueService boutiqueService;
    final ProduitService produitService;


    public BoutiqueController(PersonneService personneService, BoutiqueService boutiqueService, ProduitService produitService) {
        this.personneService = personneService;
        this.boutiqueService = boutiqueService;
        this.produitService = produitService;
    }

    @PostMapping(path = "/creer_boutique")
    public BoutiqueResponse creerBoutique(@RequestParam("nom") String nom,
                                       @RequestParam("baniere") String baniere,
                                       @RequestParam("localisation") String localisation,
                                       @RequestParam("id_personne") Long id_personne){

        // champs vide
        if(nom.isEmpty() || localisation.isEmpty()){
            return new BoutiqueResponse("Veuillez remplir tous les champs", "Bad Request");
        }

        Boutique boutique = new Boutique(nom, baniere, localisation, id_personne, new Date());

        Boutique registeredBoutique = boutiqueService.save(boutique);





        return new BoutiqueResponse("Boutique crée", "Request Ok", registeredBoutique);

    }


    // My Boutique
    @GetMapping(path = "/my_boutique")
    public BoutiqueResponse myBoutique(@RequestParam("boutiqueId") Long boutiqueId){

        Boutique boutique = boutiqueService.findBoutiqueById(boutiqueId);


        if (boutique != null) {
            BoutiqueResponse boutiqueResponse = new BoutiqueResponse("Boutique retrouvée", "Request Ok", boutique);
            ArrayList<Produit> produits = produitService.findProduitsOfMyBoutique(boutiqueId);

            boutiqueResponse.setProduits(produits);
            return boutiqueResponse;
        }

        return new BoutiqueResponse("Boutique non trouvée", "Bad Request");
    }


}
