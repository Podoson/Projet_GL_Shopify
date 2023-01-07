package com.shopify.Repositories;

import com.shopify.Models.Boutique;
import com.shopify.Models.Panier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PanierRepository extends JpaRepository<Panier, Long> {

    ArrayList<Panier> findAllByIdPersonne(Long idPersonne);
}
