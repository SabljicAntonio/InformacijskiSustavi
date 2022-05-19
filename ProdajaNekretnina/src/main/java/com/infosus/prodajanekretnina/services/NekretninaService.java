package com.infosus.prodajanekretnina.services;

import com.infosus.prodajanekretnina.domain.AgentZaNekretnine;
import com.infosus.prodajanekretnina.domain.Nekretnina;
import com.infosus.prodajanekretnina.repositories.NekretninaRepository;
import com.infosus.prodajanekretnina.repositories.OsobaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NekretninaService {
    private final NekretninaRepository nekretninaRepository;

    @Autowired
    public NekretninaService(NekretninaRepository nekretninaRepository) {
        this.nekretninaRepository = nekretninaRepository;
    }

    public List<Nekretnina> getAllNekretnina() {
        List<Nekretnina> nekretnineList = nekretninaRepository.findAll();
        return nekretnineList;
    }

    public AgentZaNekretnine getAgentByNekretninaId(Integer id) {
       Nekretnina nek =  nekretninaRepository.getById(id);
       if(nek == null) return null;
       AgentZaNekretnine agent = nek.getAgent();
       return agent;
    }
}
