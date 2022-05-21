package com.infosus.prodajanekretnina.controllers;

import com.infosus.prodajanekretnina.services.AgentZaNekretnineService;
import com.infosus.prodajanekretnina.services.DrzavaService;
import com.infosus.prodajanekretnina.services.NekretninaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    private final AgentZaNekretnineService agentZaNekretnineService;
    private final NekretninaService nekretninaService;
    private final DrzavaService drzavaService;

    @Autowired
    public MainController(AgentZaNekretnineService agentZaNekretnineService, NekretninaService nekretninaService, DrzavaService drzavaService) {
        this.agentZaNekretnineService = agentZaNekretnineService;
        this.nekretninaService = nekretninaService;
        this.drzavaService = drzavaService;
    }


    @GetMapping(path = "/")
    public String getHomePage(Model model) {
        model.addAttribute("nekretnine", nekretninaService.getAllNekretnina());
        model.addAttribute("agents", agentZaNekretnineService.getAllAgents());
        model.addAttribute("drzave", drzavaService.getAllDrzava());
        return "home";
    }



}
