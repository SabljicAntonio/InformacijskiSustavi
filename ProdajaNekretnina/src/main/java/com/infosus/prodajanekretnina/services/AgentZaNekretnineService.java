package com.infosus.prodajanekretnina.services;

import com.infosus.prodajanekretnina.domain.AgentZaNekretnine;
import com.infosus.prodajanekretnina.domain.Korisnik;
import com.infosus.prodajanekretnina.repositories.AgentZaNekretnineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgentZaNekretnineService implements UserDetailsService {
    private final static String USER_NOT_FOUND_MSG = "User with username %s not found";
    private final AgentZaNekretnineRepository agentZaNekretnineRepository;
    @Autowired
    public AgentZaNekretnineService(AgentZaNekretnineRepository agentZaNekretnineRepository) {
        this.agentZaNekretnineRepository = agentZaNekretnineRepository;
    }
    public List<AgentZaNekretnine> getAllAgents() {
        List<AgentZaNekretnine> agents = agentZaNekretnineRepository.findAll();
        return agents;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return agentZaNekretnineRepository.findAgentZaNekretnineByNazivAgenta(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG,username)));
    }

    public Optional<AgentZaNekretnine> getAgentByUsername(String username) {
        return agentZaNekretnineRepository.findAgentZaNekretnineByNazivAgenta(username);
    }

    public boolean signUpAgent(AgentZaNekretnine agent) {
        if(agentZaNekretnineRepository.save(agent) == null) {
            return false;
        }
        return true;
    }
}
