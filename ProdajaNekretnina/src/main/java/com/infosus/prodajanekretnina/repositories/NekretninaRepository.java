package com.infosus.prodajanekretnina.repositories;

import com.infosus.prodajanekretnina.domain.Nekretnina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NekretninaRepository extends JpaRepository<Nekretnina, Integer> {
}