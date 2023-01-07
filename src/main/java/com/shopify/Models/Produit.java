package com.shopify.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "produit")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String categorie;
    private Long prix;
    private String description;
    private String image;

    @Column(name = "id_boutique")
    private Long idBoutique;

    @Column(name = "created_at")
    private Date createdAt;

    public Produit(String nom, String categorie, Long prix, String description, String image, Long idBoutique, Date createdAt) {
        this.nom = nom;
        this.categorie = categorie;
        this.prix = prix;
        this.description = description;
        this.image = image;
        this.idBoutique = idBoutique;
        this.createdAt = createdAt;
    }

    public Produit() {

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

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Long getPrix() {
        return prix;
    }

    public void setPrix(Long prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getIdBoutique() {
        return idBoutique;
    }

    public void setIdBoutique(Long idBoutique) {
        this.idBoutique = idBoutique;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
