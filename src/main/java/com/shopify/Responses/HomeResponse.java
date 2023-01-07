package com.shopify.Responses;

import com.shopify.Models.Personne;
import com.shopify.Models.Produit;

import java.util.ArrayList;

public class HomeResponse {
    private String body;
    private String status;
    private Personne principal;
    private ArrayList<Produit> produits = new ArrayList<>();

    public HomeResponse() {
    }

    public HomeResponse(String body, String status) {
        this.body = body;
        this.status = status;
    }

    public HomeResponse(String body, String status, Personne principal) {
        this.status = status;
        this.body = body;
        this.principal = principal;
    }

    public HomeResponse(String body, String status, ArrayList<Produit> produits) {
        this.body = body;
        this.status = status;
        this.produits = produits;
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

    public ArrayList<Produit> getProduits() {
        return produits;
    }

    public void setProduits(ArrayList<Produit> produits) {
        this.produits = produits;
    }
}
