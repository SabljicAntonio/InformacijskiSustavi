package com.infosus.prodajanekretnina.repositories;

import com.infosus.prodajanekretnina.domain.Drzava;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrzavaRepository extends JpaRepository<Drzava, Integer> {
}