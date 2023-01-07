package com.shopify.Responses;

import com.shopify.Models.Boutique;
import com.shopify.Models.Personne;
import com.shopify.Models.Produit;

import java.util.ArrayList;

public class BoutiqueResponse {
    private String body;
    private String status;
    private Boutique boutique;
    private ArrayList<Produit> produits = new ArrayList<>();

    public BoutiqueResponse() {
    }

    public BoutiqueResponse(String body, String status) {
        this.body = body;
        this.status = status;
    }

    public BoutiqueResponse(String body, String status, Boutique boutique) {
        this.status = status;
        this.body = body;
        this.boutique = boutique;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Boutique getBoutique() {
        return boutique;
    }

    public void setBoutique(Boutique boutique) {
        this.boutique = boutique;
    }

    public ArrayList<Produit> getProduits() {
        return produits;
    }

    public void setProduits(ArrayList<Produit> produits) {
        this.produits = produits;
    }
}
