package com.shopify.Responses;

import com.shopify.Models.Boutique;
import com.shopify.Models.Produit;

public class ProduitResponse {
    private String body;
    private String status;
    private Produit produit;

    public ProduitResponse() {
    }

    public ProduitResponse(String body, String status) {
        this.body = body;
        this.status = status;
    }

    public ProduitResponse(String body, String status, Produit produit) {
        this.status = status;
        this.body = body;
        this.produit = produit;
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

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
