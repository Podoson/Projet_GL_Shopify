package com.shopify.Repositories;

import com.shopify.Models.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Long> {

    Personne findByEmail(String email);
}
