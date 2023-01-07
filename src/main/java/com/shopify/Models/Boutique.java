package com.shopify.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "boutique")
public class Boutique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String baniere;
    private String localisation;

    @Column(name = "id_personne")
    private Long idPersonne;

    @Column(name = "created_at")
    private Date createdAt;

    public Boutique(String nom, String baniere, String localisation, Long idPersonne, Date createdAt) {
        this.nom = nom;
        this.baniere = baniere;
        this.localisation = localisation;
        this.idPersonne = idPersonne;
        this.createdAt = createdAt;
    }

    public Boutique() {

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

    public String getBaniere() {
        return baniere;
    }

    public void setBaniere(String baniere) {
        this.baniere = baniere;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public Long getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Long idPersonne) {
        this.idPersonne = idPersonne;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
