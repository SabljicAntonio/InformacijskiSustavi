package com.infosus.prodajanekretnina.repositories;

import com.infosus.prodajanekretnina.domain.Osoba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OsobaRepository extends JpaRepository<Osoba, Integer> {
}