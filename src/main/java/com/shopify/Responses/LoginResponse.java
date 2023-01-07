package com.shopify.Responses;

import com.shopify.Models.Personne;

public class LoginResponse {
    private String body;
    private String status;
    private Personne principal;

    public LoginResponse() {
    }

    public LoginResponse( String body, String status) {
        this.body = body;
        this.status = status;
    }

    public LoginResponse(String body, String status, Personne principal) {
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
}
