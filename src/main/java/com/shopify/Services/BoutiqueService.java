package com.shopify.Services;

import com.shopify.Models.Boutique;

import java.util.ArrayList;

public interface BoutiqueService {
    Boutique save(Boutique boutique);

    ArrayList<Boutique> findMyBoutiques(Long principalId);

    Boutique findBoutiqueById(Long boutiqueId);
}
