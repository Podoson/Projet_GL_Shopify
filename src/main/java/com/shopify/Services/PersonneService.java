package com.shopify.Services;

import com.shopify.Models.Personne;

public interface PersonneService {
    Personne findPrincipal(String email);

    Personne save(Personne personne);

    Personne findById(Long principalId);
}
