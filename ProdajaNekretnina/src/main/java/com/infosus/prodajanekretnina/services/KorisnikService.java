package com.infosus.prodajanekretnina.services;

import com.infosus.prodajanekretnina.domain.Korisnik;
import com.infosus.prodajanekretnina.repositories.AgentZaNekretnineRepository;
import com.infosus.prodajanekretnina.repositories.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KorisnikService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "User with username %s not found";
    private final KorisnikRepository korisnikRepository;

    @Autowired
    public KorisnikService(KorisnikRepository korisnikRepository) {
        this.korisnikRepository = korisnikRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return korisnikRepository.findByNazivKor(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG,username)));
    }

    public Optional<Korisnik> getKorisnikByUsername(String username) {
        return korisnikRepository.findByNazivKor(username);
    }

    public boolean signUpKorisnik(Korisnik korisnik) {
        if(korisnikRepository.save(korisnik) == null) {
            return false;
        }
        return true;
    }

}
