package com.infosus.prodajanekretnina.repositories;

import com.infosus.prodajanekretnina.domain.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Integer> {
}