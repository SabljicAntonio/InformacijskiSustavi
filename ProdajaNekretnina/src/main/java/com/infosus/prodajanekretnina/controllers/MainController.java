package com.infosus.prodajanekretnina.controllers;

import com.infosus.prodajanekretnina.services.AgentZaNekretnineService;
import com.infosus.prodajanekretnina.services.NekretninaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    private final AgentZaNekretnineService agentZaNekretnineService;
    private final NekretninaService nekretninaService;

    @Autowired
    public MainController(AgentZaNekretnineService agentZaNekretnineService, NekretninaService nekretninaService) {
        this.agentZaNekretnineService = agentZaNekretnineService;
        this.nekretninaService = nekretninaService;

    }


    @GetMapping(path = "/")
    public String getHomePage(Model model) {
        model.addAttribute("nekretnine", nekretninaService.getAllNekretnina());
        model.addAttribute("agents", agentZaNekretnineService.getAllAgents());
        return "home";
    }



}
