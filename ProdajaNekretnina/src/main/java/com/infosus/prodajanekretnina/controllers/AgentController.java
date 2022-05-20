package com.infosus.prodajanekretnina.controllers;

import com.infosus.prodajanekretnina.domain.AgentZaNekretnine;
import com.infosus.prodajanekretnina.security.DeleteRequestAgent;
import com.infosus.prodajanekretnina.security.PutRequestAgent;
import com.infosus.prodajanekretnina.security.RegistrationRequestAgent;
import com.infosus.prodajanekretnina.services.AgentZaNekretnineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AgentController {

    private final AgentZaNekretnineService agentZaNekretnineService;
    @Autowired
    public AgentController(AgentZaNekretnineService agentZaNekretnineService) {
        this.agentZaNekretnineService = agentZaNekretnineService;
    }


    @PostMapping(path = "/register/agent")
    public String registerAgent(@RequestBody RegistrationRequestAgent req)
    {
        String status = agentZaNekretnineService.registerAgent(req);
        return status;
    }

    @DeleteMapping(path = "/delete/agent")
    public String deleteAgent(@RequestBody DeleteRequestAgent req) {
        String status = agentZaNekretnineService.deleteAgent(req);
        return status;
    }

    @PutMapping(path = "/change/agent")
    public String putAgent(@RequestBody PutRequestAgent req) {
        String status = agentZaNekretnineService.putAgent(req);
        return status;
    }
    @GetMapping(path = "/agents")
    public List<AgentZaNekretnine> getAllAgents() {
        return agentZaNekretnineService.getAllAgents();
    }


}
