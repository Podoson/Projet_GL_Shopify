package com.shopify.Services.impl;

import com.shopify.Models.Personne;
import com.shopify.Repositories.BoutiqueRepository;
import com.shopify.Repositories.PersonneRepository;
import com.shopify.Repositories.ProduitRepository;
import com.shopify.Services.PersonneService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonneServiceImpl implements PersonneService {

    final PersonneRepository personneRepository;
    final BoutiqueRepository boutiqueRepository;
    final ProduitRepository produitRepository;

    public PersonneServiceImpl(PersonneRepository personneRepository, BoutiqueRepository boutiqueRepository, ProduitRepository produitRepository) {
        this.personneRepository = personneRepository;
        this.boutiqueRepository = boutiqueRepository;
        this.produitRepository = produitRepository;
    }



    @Override
    public Personne findPrincipal(String email) {
        return personneRepository.findByEmail(email);
    }

    @Override
    public Personne save(Personne personne) {
        return personneRepository.save(personne);
    }

    @Override
    public Personne findById(Long principalId) {
        Optional<Personne> optionalPersonne = personneRepository.findById(principalId);

        return optionalPersonne.orElse(null);
    }
}
