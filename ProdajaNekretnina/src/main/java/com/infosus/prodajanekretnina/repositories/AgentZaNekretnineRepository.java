package com.infosus.prodajanekretnina.repositories;

import com.infosus.prodajanekretnina.domain.AgentZaNekretnine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgentZaNekretnineRepository extends JpaRepository<AgentZaNekretnine, Integer> {
    Optional<AgentZaNekretnine> findAgentZaNekretnineByNazivAgenta(String username);
}