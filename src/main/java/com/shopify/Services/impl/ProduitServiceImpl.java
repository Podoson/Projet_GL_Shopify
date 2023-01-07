package com.shopify.Services.impl;

import com.shopify.Models.Produit;
import com.shopify.Repositories.BoutiqueRepository;
import com.shopify.Repositories.PersonneRepository;
import com.shopify.Repositories.ProduitRepository;
import com.shopify.Services.ProduitService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProduitServiceImpl implements ProduitService {

    final PersonneRepository personneRepository;
    final BoutiqueRepository boutiqueRepository;
    final ProduitRepository produitRepository;

    public ProduitServiceImpl(PersonneRepository personneRepository, BoutiqueRepository boutiqueRepository, ProduitRepository produitRepository) {
        this.personneRepository = personneRepository;
        this.boutiqueRepository = boutiqueRepository;
        this.produitRepository = produitRepository;
    }

    @Override
    public Produit save(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public ArrayList<Produit> findMyPanierProduits(ArrayList<Long> produitsIds) {
        return produitRepository.findAllByIdIsIn(produitsIds);
    }

    @Override
    public ArrayList<Produit> findProduitsOfMyBoutique(Long boutiqueId) {
        return produitRepository.findAllByIdBoutique(boutiqueId);
    }

    @Override
    public Produit findProduitById(Long produitId) {
        Optional<Produit> optionalProduit = produitRepository.findById(produitId);
        return optionalProduit.orElse(null);
    }

    @Override
    public ArrayList<Produit> findProduitsRandom() {
        return produitRepository.findProduitRandom();
    }

    @Override
    public ArrayList<Produit> searchProduits(String query) {
        return produitRepository.searchProduits(query);
    }
}
