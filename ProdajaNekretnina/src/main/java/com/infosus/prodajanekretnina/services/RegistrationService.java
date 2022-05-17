package com.infosus.prodajanekretnina.services;

import com.infosus.prodajanekretnina.domain.AgentZaNekretnine;
import com.infosus.prodajanekretnina.domain.Korisnik;
import com.infosus.prodajanekretnina.domain.Osoba;
import com.infosus.prodajanekretnina.repositories.KorisnikRepository;
import com.infosus.prodajanekretnina.repositories.OsobaRepository;
import com.infosus.prodajanekretnina.security.EmailValidator;
import com.infosus.prodajanekretnina.security.RegistrationRequestAgent;
import com.infosus.prodajanekretnina.security.RegistrationRequestKorisnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final EmailValidator emailValidator;
    private final KorisnikService korisnikService;
    private final OsobaService osobaService;
    private final static String USER_ALREADY_EXISTS = "User with username %s already exists!";
    private final AgentZaNekretnineService agentZaNekretnineService;


    @Autowired
    public RegistrationService(EmailValidator emailValidator, KorisnikService korisnikService, OsobaService osobaService, AgentZaNekretnineService agentZaNekretnineService) {
        this.emailValidator = emailValidator;
        this.korisnikService = korisnikService;
        this.osobaService = osobaService;
        this.agentZaNekretnineService = agentZaNekretnineService;
    }


    public String registerKorisnik(RegistrationRequestKorisnik req) {
        Osoba o;
        boolean isValidMail = emailValidator.test(req.getEmail());
        if(!isValidMail) throw new IllegalStateException();
        if(!osobaService.getOsobaByOib(req.getOib()).isPresent()) {
            o = new Osoba(req.getOib(), req.getIme(), req.getPrezime(), req.getDatumRod());
            osobaService.storeOsoba(o);
        } else {
            o = osobaService.getOsobaByOib(req.getOib()).get();
        }


        if(korisnikService.getKorisnikByUsername(req.getNazivKor()).isPresent()) {
            throw new IllegalStateException(String.format(USER_ALREADY_EXISTS,req.getNazivKor()));
        }
        Korisnik k = new Korisnik(req.getNazivKor(), req.getEmail(), req.getSifra(), o);
        boolean reply = korisnikService.signUpKorisnik(k);
        if(reply == true) System.out.println("Uspjesno registiranje korisnika");
        return "works";
    }

    public String registerAgent(RegistrationRequestAgent req) {
        Osoba o;
        boolean isValidMail = emailValidator.test(req.getEmail());
        if(!isValidMail) throw new IllegalStateException();
        if(!osobaService.getOsobaByOib(req.getOib()).isPresent()) {
            o = new Osoba(req.getOib(), req.getIme(), req.getPrezime(), req.getDatumRod());
            osobaService.storeOsoba(o);
        } else {
            o = osobaService.getOsobaByOib(req.getOib()).get();
        }

        if(agentZaNekretnineService.getAgentByUsername(req.getNazivAgenta()).isPresent()) {
            throw new IllegalStateException(String.format(USER_ALREADY_EXISTS,req.getNazivAgenta()));
        }
        AgentZaNekretnine a = new AgentZaNekretnine(req.getNazivAgenta(), req.getProdNek(), req.getEmail(), req.getSifra(), req.getOpis(), o);
        boolean reply = agentZaNekretnineService.signUpAgent(a);
        if(reply == true) System.out.println("Uspjesno registiranje agenta");
        return "works";
    }
}
