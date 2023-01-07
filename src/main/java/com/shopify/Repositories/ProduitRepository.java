package com.shopify.Repositories;

import com.shopify.Models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {

    ArrayList<Produit> findAllByIdIsIn(ArrayList<Long> ids);
    ArrayList<Produit> findAllByIdBoutique(Long idBoutique);

    @Transactional
    @Query(value = "SELECT * FROM produit ORDER BY RAND() LIMIT 30", nativeQuery = true)
    ArrayList<Produit> findProduitRandom();

    @Transactional
    @Query("SELECT p FROM Produit p WHERE p.nom LIKE CONCAT('%', ?1, '%') OR p.categorie LIKE CONCAT('%', ?1, '%')")
    ArrayList<Produit> searchProduits(String query);
}
