package com.shopify.Services.impl;

import com.shopify.Models.Boutique;
import com.shopify.Repositories.BoutiqueRepository;
import com.shopify.Repositories.PersonneRepository;
import com.shopify.Repositories.ProduitRepository;
import com.shopify.Services.BoutiqueService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class BoutiqueServiceImpl implements BoutiqueService {

    final PersonneRepository personneRepository;
    final BoutiqueRepository boutiqueRepository;
    final ProduitRepository produitRepository;

    public BoutiqueServiceImpl(PersonneRepository personneRepository, BoutiqueRepository boutiqueRepository, ProduitRepository produitRepository) {
        this.personneRepository = personneRepository;
        this.boutiqueRepository = boutiqueRepository;
        this.produitRepository = produitRepository;
    }


    @Override
    public Boutique save(Boutique boutique) {
        return boutiqueRepository.save(boutique);
    }

    @Override
    public ArrayList<Boutique> findMyBoutiques(Long principalId) {
        return boutiqueRepository.findAllByIdPersonne(principalId);
    }

    @Override
    public Boutique findBoutiqueById(Long boutiqueId) {
        Optional<Boutique> optionalBoutique = boutiqueRepository.findById(boutiqueId);
        return optionalBoutique.orElse(null);
    }
}
