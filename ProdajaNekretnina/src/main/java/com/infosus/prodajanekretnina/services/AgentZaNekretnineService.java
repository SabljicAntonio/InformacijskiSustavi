package com.infosus.prodajanekretnina.services;

import com.infosus.prodajanekretnina.domain.AgentZaNekretnine;
import com.infosus.prodajanekretnina.repositories.AgentZaNekretnineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentZaNekretnineService {
    private final AgentZaNekretnineRepository agentZaNekretnineRepository;
    @Autowired
    public AgentZaNekretnineService(AgentZaNekretnineRepository agentZaNekretnineRepository) {
        this.agentZaNekretnineRepository = agentZaNekretnineRepository;
    }
    public List<AgentZaNekretnine> getAllAgents() {
        List<AgentZaNekretnine> agents = agentZaNekretnineRepository.findAll();
        return agents;
    }
}
