package com.infosus.prodajanekretnina.services;

import com.infosus.prodajanekretnina.domain.Osoba;
import com.infosus.prodajanekretnina.repositories.OsobaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class OsobaService {

    private final OsobaRepository osobaRepository;
    private final static String USER_NOT_FOUND_MSG = "User with username %s not found";

    @Autowired
    public OsobaService(OsobaRepository osobaRepository) {
        this.osobaRepository = osobaRepository;
    }

    Optional<Osoba> getOsobaByOib(BigDecimal oib) {
        Optional<Osoba> o = osobaRepository.findOsobaByOib(oib);
        return o;
    }

    public boolean storeOsoba(Osoba o) {
        if(osobaRepository.save(o) == null) {
            return false;
        }
        return true;

    }
}
