package com.infosus.prodajanekretnina.controllers;

import com.infosus.prodajanekretnina.domain.AgentZaNekretnine;
import com.infosus.prodajanekretnina.services.AgentZaNekretnineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {
    private final AgentZaNekretnineService agentZaNekretnineService;

    @Autowired
    public MainController(AgentZaNekretnineService agentZaNekretnineService) {
        this.agentZaNekretnineService = agentZaNekretnineService;
    }

    @GetMapping("/agents")
    @ResponseBody
    public ResponseEntity<List<AgentZaNekretnine>> getAgents() {
        return ResponseEntity.ok(agentZaNekretnineService.getAllAgents());
    }
}
