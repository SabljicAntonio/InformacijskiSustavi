package com.infosus.prodajanekretnina.repositories;

import com.infosus.prodajanekretnina.domain.Drzava;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DrzavaRepository extends JpaRepository<Drzava, Integer> {
    Optional<Drzava> findDrzavaByNaziv(String naziv);
}