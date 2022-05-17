package com.infosus.prodajanekretnina.repositories;

import com.infosus.prodajanekretnina.domain.Osoba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface OsobaRepository extends JpaRepository<Osoba, Integer> {
    Optional<Osoba> findOsobaByOib(BigDecimal oib);

}