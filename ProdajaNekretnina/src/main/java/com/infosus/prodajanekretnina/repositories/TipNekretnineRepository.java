package com.infosus.prodajanekretnina.repositories;

import com.infosus.prodajanekretnina.domain.TipNekretnine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipNekretnineRepository extends JpaRepository<TipNekretnine, Integer> {
}