package com.infosus.prodajanekretnina.controllers;

import com.infosus.prodajanekretnina.domain.AgentZaNekretnine;
import com.infosus.prodajanekretnina.security.RegistrationRequestKorisnik;
import com.infosus.prodajanekretnina.services.AgentZaNekretnineService;
import com.infosus.prodajanekretnina.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {
    private final AgentZaNekretnineService agentZaNekretnineService;
    private final RegistrationService registrationService;

    @Autowired
    public MainController(AgentZaNekretnineService agentZaNekretnineService, RegistrationService registrationService) {
        this.agentZaNekretnineService = agentZaNekretnineService;
        this.registrationService = registrationService;
    }

    @GetMapping("/agents")
    @ResponseBody
    public ResponseEntity<List<AgentZaNekretnine>> getAgents() {
        return ResponseEntity.ok(agentZaNekretnineService.getAllAgents());
    }

    @PostMapping(path = "/register/korisnik")
    @ResponseBody
    public String register(@RequestBody RegistrationRequestKorisnik request) {
        return registrationService.registerKorisnik(request);

    }
}
