package com.shopify.Services;

import com.shopify.Models.Panier;

import java.util.ArrayList;

public interface PanierService {
    ArrayList<Panier> findMyPaniers(Long principalId);
}
