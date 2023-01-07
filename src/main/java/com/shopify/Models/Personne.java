package com.shopify.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "personne", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String nom;
    private String prenom;
    private String email;
    private String password;

    @Column(name = "created_at")
    private Date createdAt;

    public Personne(String nom, String prenom, String email, String password, Date createdAt) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
    }

    public Personne() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
