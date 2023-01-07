package com.shopify.Services.impl;

import com.shopify.Models.Panier;
import com.shopify.Repositories.BoutiqueRepository;
import com.shopify.Repositories.PanierRepository;
import com.shopify.Repositories.PersonneRepository;
import com.shopify.Repositories.ProduitRepository;
import com.shopify.Services.PanierService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PanierServiceImpl implements PanierService {

    final PersonneRepository personneRepository;
    final BoutiqueRepository boutiqueRepository;
    final ProduitRepository produitRepository;
    final PanierRepository panierRepository;

    public PanierServiceImpl(PersonneRepository personneRepository, BoutiqueRepository boutiqueRepository, ProduitRepository produitRepository, PanierRepository panierRepository) {
        this.personneRepository = personneRepository;
        this.boutiqueRepository = boutiqueRepository;
        this.produitRepository = produitRepository;
        this.panierRepository = panierRepository;
    }

    @Override
    public ArrayList<Panier> findMyPaniers(Long principalId) {
        return panierRepository.findAllByIdPersonne(principalId);
    }
}
