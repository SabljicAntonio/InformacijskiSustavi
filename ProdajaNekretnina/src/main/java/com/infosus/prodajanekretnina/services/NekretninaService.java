package com.infosus.prodajanekretnina.services;

import com.infosus.prodajanekretnina.domain.AgentZaNekretnine;
import com.infosus.prodajanekretnina.domain.Drzava;
import com.infosus.prodajanekretnina.domain.Nekretnina;
import com.infosus.prodajanekretnina.domain.TipNekretnine;
import com.infosus.prodajanekretnina.repositories.*;
import com.infosus.prodajanekretnina.requests.nekretnina.DeleteRequestNekretnina;
import com.infosus.prodajanekretnina.requests.nekretnina.PutRequestNekretnina;
import com.infosus.prodajanekretnina.requests.nekretnina.RegistrationRequestNekretnina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NekretninaService {
    private final NekretninaRepository nekretninaRepository;
    private final AgentZaNekretnineRepository agentZaNekretnineRepository;
    private final DrzavaRepository drzavaRepository;
    private final TipNekretnineRepository tipNekretnineRepository;

    @Autowired
    public NekretninaService(NekretninaRepository nekretninaRepository,
                             AgentZaNekretnineRepository agentZaNekretnineRepository,
                             DrzavaRepository drzavaRepository,
                             TipNekretnineRepository tipNekretnineRepository) {
        this.nekretninaRepository = nekretninaRepository;
        this.agentZaNekretnineRepository = agentZaNekretnineRepository;
        this.drzavaRepository = drzavaRepository;
        this. tipNekretnineRepository = tipNekretnineRepository;
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

    public String registerNekretnina(RegistrationRequestNekretnina req) {

        if(req.getNazivNek() == null ||
           req.getAdresa() == null ||
           req.getPovrsina() == null ||
           req.getCijena() == null ||
           req.getStatus() == null ||
           req.getNazivAgenta() == null ||
           req.getDrzava() == null ||
           req.getTipNek() == null) return "Neispravan zahtjev za registriranje nekretnine!";

        Optional<Nekretnina> nekByNaz = nekretninaRepository.findNekretninaByNazivNek(req.getNazivNek());
        Optional<Nekretnina> nekByAdr = nekretninaRepository.findNekretninaByAdresa(req.getAdresa());
        Optional<Drzava> drz = drzavaRepository.findDrzavaByNaziv(req.getDrzava());
        Optional<AgentZaNekretnine> ag = agentZaNekretnineRepository.findAgentZaNekretnineByNazivAgenta(req.getNazivAgenta());
        Optional<TipNekretnine> tipNek = tipNekretnineRepository.findTipNekretnineByNazivTipa(req.getTipNek());

        if(nekByNaz.isPresent()) return "Nekretnina sa nazivom: " + req.getNazivNek() + " već postoji!";
        if(nekByAdr.isPresent()) return "Nekretnina sa adresom: " + req.getAdresa() + " već postoji!";
        if(!drz.isPresent()) return "Država sa nazivom: " + req.getDrzava() + " ne postoji!";
        if(!ag.isPresent()) return "Agent za nekretnine sa nazivom: " + req.getNazivAgenta() + " ne postoji!";
        if(!tipNek.isPresent()) return "Tip nekretnine: " + req.getTipNek() + " ne postoji!";

        Nekretnina novaNek = new Nekretnina(req.getNazivNek(), req.getAdresa(), req.getPovrsina(), req.getOcjena(), req.getOpis(), req.getCijena(), req.getStatus(), ag.get(), drz.get(), tipNek.get());

        nekretninaRepository.save(novaNek);

        return "Uspjesno registriranje nekretnine: " + novaNek;
    }

    public String deleteNekretnina(DeleteRequestNekretnina req) {
        Optional<Nekretnina> nekByNaz = nekretninaRepository.findNekretninaByNazivNek(req.getNazivNek());
        if(nekByNaz.isPresent()) {
            nekretninaRepository.delete(nekByNaz.get());
            return "Nekretnina: " + req.getNazivNek() + " je obrisana!";
        }
        return "Ne postoji nekretnina sa nazivom: " + req.getNazivNek();
    }

    public String putNekretnina(PutRequestNekretnina req) {

        if(req.getNazivNek() == null ||
                req.getAdresa() == null ||
                req.getPovrsina() == null ||
                req.getCijena() == null ||
                req.getStatus() == null ||
                req.getNazivAgenta() == null ||
                req.getDrzava() == null ||
                req.getTipNek() == null) return "Neispravan zahtjev za mijenjanje nekretnine!";

        Optional<Nekretnina> nekByNaz = nekretninaRepository.findNekretninaByNazivNek(req.getNazivNek());
        if(!nekByNaz.isPresent()) return "Nekretnina sa nazivom: " + req.getNazivNek() + " ne postoji!";
        if(!agentZaNekretnineRepository.findAgentZaNekretnineByNazivAgenta(req.getNazivAgenta()).isPresent()) return "Ne postoji agent sa nazivom: " + req.getNazivAgenta();
        if(!drzavaRepository.findDrzavaByNaziv(req.getDrzava()).isPresent()) return "Ne postoji država sa nazivom: " + req.getDrzava();
        if(!tipNekretnineRepository.findTipNekretnineByNazivTipa(req.getTipNek()).isPresent()) return "Ne postoji tip nekretnine sa nazivom: " + req.getTipNek();
        if(nekretninaRepository.findNekretninaByNazivNek(req.getNoviNazivNek()).isPresent()) return "Nije moguće promjeniti naziv nekretnine u naziv koji već postoji!";

        Nekretnina nek = nekByNaz.get();
        Nekretnina novaNek;
        if(req.getNoviNazivNek() != null) {
                    novaNek = new Nekretnina(req.getNoviNazivNek(),
                    req.getAdresa(),
                    req.getPovrsina(),
                    req.getOcjena(),
                    req.getOpis(),
                    req.getCijena(),
                    req.getStatus(),
                    agentZaNekretnineRepository.findAgentZaNekretnineByNazivAgenta(req.getNazivAgenta()).get(),
                    drzavaRepository.findDrzavaByNaziv(req.getDrzava()).get(),
                    tipNekretnineRepository.findTipNekretnineByNazivTipa(req.getTipNek()).get());
        } else {
                    novaNek = new Nekretnina(req.getNazivNek(),
                    req.getAdresa(),
                    req.getPovrsina(),
                    req.getOcjena(),
                    req.getOpis(),
                    req.getCijena(),
                    req.getStatus(),
                    agentZaNekretnineRepository.findAgentZaNekretnineByNazivAgenta(req.getNazivAgenta()).get(),
                    drzavaRepository.findDrzavaByNaziv(req.getDrzava()).get(),
                    tipNekretnineRepository.findTipNekretnineByNazivTipa(req.getTipNek()).get());

        }
        nekretninaRepository.delete(nek);
        nekretninaRepository.save(novaNek);
        return "Done! \n" + novaNek;
    }
}
