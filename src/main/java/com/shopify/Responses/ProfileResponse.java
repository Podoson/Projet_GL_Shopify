package com.shopify.Responses;

import com.shopify.Models.Boutique;
import com.shopify.Models.Personne;
import com.shopify.Models.Produit;

import java.util.ArrayList;

public class ProfileResponse {
    private String body;
    private String status;
    private Personne principal;
    private ArrayList<Boutique> boutiques = new ArrayList<>();
    private ArrayList<Produit> produits = new ArrayList<>();

    public ProfileResponse() {
    }

    public ProfileResponse(String body, String status) {
        this.body = body;
        this.status = status;
    }

    public ProfileResponse(String status, String body, Personne principal) {
        this.status = status;
        this.body = body;
        this.principal = principal;
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

    public Personne getPrincipal() {
        return principal;
    }

    public void setPrincipal(Personne principal) {
        this.principal = principal;
    }

    public ArrayList<Boutique> getBoutiques() {
        return boutiques;
    }

    public void setBoutiques(ArrayList<Boutique> boutiques) {
        this.boutiques = boutiques;
    }

    public ArrayList<Produit> getProduits() {
        return produits;
    }

    public void setProduits(ArrayList<Produit> produits) {
        this.produits = produits;
    }
}
