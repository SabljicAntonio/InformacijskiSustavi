package com.infosus.prodajanekretnina.repositories;

import com.infosus.prodajanekretnina.domain.TipNekretnine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipNekretnineRepository extends JpaRepository<TipNekretnine, Integer> {
    Optional<TipNekretnine> findTipNekretnineByNazivTipa(String naziv);
}