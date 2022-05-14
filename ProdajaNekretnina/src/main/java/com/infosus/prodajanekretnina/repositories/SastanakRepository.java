package com.infosus.prodajanekretnina.repositories;

import com.infosus.prodajanekretnina.domain.Sastanak;
import com.infosus.prodajanekretnina.domain.SastanakPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SastanakRepository extends JpaRepository<Sastanak, SastanakPK> {
}