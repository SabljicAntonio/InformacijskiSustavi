package com.infosus.prodajanekretnina.services;

import com.infosus.prodajanekretnina.domain.AgentZaNekretnine;
import com.infosus.prodajanekretnina.domain.Osoba;
import com.infosus.prodajanekretnina.repositories.AgentZaNekretnineRepository;
import com.infosus.prodajanekretnina.requests.agent.DeleteRequestAgent;
import com.infosus.prodajanekretnina.requests.agent.PutRequestAgent;
import com.infosus.prodajanekretnina.requests.agent.RegistrationRequestAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgentZaNekretnineService {
    private final AgentZaNekretnineRepository agentZaNekretnineRepository;
    private final OsobaService osobaService;
    @Autowired
    public AgentZaNekretnineService(AgentZaNekretnineRepository agentZaNekretnineRepository, OsobaService osobaService) {
        this.agentZaNekretnineRepository = agentZaNekretnineRepository;
        this.osobaService = osobaService;
    }
    public List<AgentZaNekretnine> getAllAgents() {
        List<AgentZaNekretnine> agents = agentZaNekretnineRepository.findAll();
        return agents;
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

    public String registerAgent(RegistrationRequestAgent req) {
        Osoba o;
        if(!osobaService.getOsobaByOib(req.getOib()).isPresent()) {
            o = new Osoba(req.getOib(), req.getIme(), req.getPrezime(), req.getDatumRod());
            osobaService.storeOsoba(o);
        } else {
            o = osobaService.getOsobaByOib(req.getOib()).get();
        }

        if(getAgentByUsername(req.getNazivAgenta()).isPresent()) {
            return "Agent sa tim usernameom već postoji!";
        }
        AgentZaNekretnine a = new AgentZaNekretnine(req.getNazivAgenta(), req.getProdNek(), req.getEmail(), req.getSifra(), req.getOpis(), o);
        boolean reply = signUpAgent(a);
        if(reply == false)  return "Neuspjesno registiranje agenta";
        return "Uspjesno registiranje agenta: " + a;
    }

    public String deleteAgent(DeleteRequestAgent req) {
        Optional<AgentZaNekretnine> agentZaDelete = agentZaNekretnineRepository.findAgentZaNekretnineByNazivAgenta(req.getNazivAgenta());
        if(agentZaDelete.isPresent()) {
            try {
                agentZaNekretnineRepository.delete(agentZaDelete.get());
            } catch(Exception e) {
                return "Nije moguće izbrisati agenta koji posjeduje nekretninu!";
            }
            return "Agent:" + agentZaDelete.get().getNazivAgenta() + " obrisan!";
        }
        return "Ne postoji agent sa nazivom: " + req.getNazivAgenta();
    }

    public String putAgent(PutRequestAgent req) {
        Optional<AgentZaNekretnine> agentZaPut = agentZaNekretnineRepository.findAgentZaNekretnineByNazivAgenta(req.getNazivAgenta());
        AgentZaNekretnine agent;
        String noviNazivAgenta = req.getNoviNazivAgenta();
        Integer noviProdNek = req.getProdNek();
        String noviEmail = req.getEmail();
        String noviSifra = req.getSifra();
        String noviOpis = req.getOpis();
        if(agentZaPut.isPresent()) {
            agent = agentZaPut.get();
            if(!agent.getNazivAgenta().equals(req.getNoviNazivAgenta())) {
                if(noviNazivAgenta != null && !agentZaNekretnineRepository.findAgentZaNekretnineByNazivAgenta(noviNazivAgenta).isPresent()) {
                    agent.setNazivAgenta(noviNazivAgenta);
                } else {
                    return "Novi naziv već postoji ili nije prosljeđen!";
                }
            }
            if(!agent.getProdNek().equals(noviProdNek)) {
                agent.setProdNek(noviProdNek);
            }
            if(!agent.getEmail().equals(noviEmail)) {
                if(agentZaNekretnineRepository.findAgentZaNekretnineByEmail(noviEmail).isPresent()) {
                    return "Agent sa navedenim mailom već postoji!";
                }
                agent.setEmail(noviEmail);
            }
            if(!agent.getSifra().equals(noviSifra)) {
                agent.setSifra(noviSifra);
            }
            if(!agent.getOpis().equals(noviOpis)) {
                agent.setOpis(noviSifra);
            }

            agentZaNekretnineRepository.delete(agentZaPut.get());
            agentZaNekretnineRepository.save(agent);

            return "Done! \n" + agent;
        }
        return "Ne postoji agent sa nazivom: " + req.getNazivAgenta();
    }
}
