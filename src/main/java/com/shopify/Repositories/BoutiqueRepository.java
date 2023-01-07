package com.shopify.Repositories;

import com.shopify.Models.Boutique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface BoutiqueRepository extends JpaRepository<Boutique, Long> {
    ArrayList<Boutique> findAllByIdPersonne(Long idPersonne);
}
