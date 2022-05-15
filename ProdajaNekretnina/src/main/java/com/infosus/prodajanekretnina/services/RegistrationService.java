package com.infosus.prodajanekretnina.services;

import com.infosus.prodajanekretnina.security.RegistrationRequestKorisnik;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    public String registerKorisnik(RegistrationRequestKorisnik req) {
        return "works";
    }

    public String registerAgent(RegistrationRequestKorisnik req) {
        return null;
    }
}
