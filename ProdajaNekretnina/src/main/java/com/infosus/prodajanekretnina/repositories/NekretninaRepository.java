package com.infosus.prodajanekretnina.repositories;

import com.infosus.prodajanekretnina.domain.Nekretnina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NekretninaRepository extends JpaRepository<Nekretnina, Integer> {
    Optional<Nekretnina> findNekretninaByNazivNek(String naziv);
    Optional<Nekretnina> findNekretninaByAdresa(String adresa);
}