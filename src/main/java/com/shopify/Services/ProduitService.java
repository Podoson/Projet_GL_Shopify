package com.shopify.Services;

import com.shopify.Models.Produit;

import java.util.ArrayList;

public interface ProduitService {
    Produit save(Produit produit);

    ArrayList<Produit> findMyPanierProduits(ArrayList<Long> produitsIds);

    ArrayList<Produit> findProduitsOfMyBoutique(Long boutiqueId);

    Produit findProduitById(Long produitId);

    ArrayList<Produit> findProduitsRandom();

    ArrayList<Produit> searchProduits(String query);
}
