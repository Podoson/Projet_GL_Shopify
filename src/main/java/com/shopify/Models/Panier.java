package com.shopify.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "panier")
public class Panier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_personne")
    private Long idPersonne;

    @Column(name = "id_produit")
    private Long idProduit;

    @Column(name = "created_at")
    private Date createdAt;

    public Panier() {
    }

    public Panier(Long idPersonne, Long idProduit, Date createdAt) {
        this.idPersonne = idPersonne;
        this.idProduit = idProduit;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Long idPersonne) {
        this.idPersonne = idPersonne;
    }

    public Long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
