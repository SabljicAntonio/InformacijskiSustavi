package com.infosus.prodajanekretnina.controllers;

import com.infosus.prodajanekretnina.services.AgentZaNekretnineService;
import com.infosus.prodajanekretnina.services.DrzavaService;
import com.infosus.prodajanekretnina.services.NekretninaService;
import com.infosus.prodajanekretnina.services.TipNekretnineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    private final AgentZaNekretnineService agentZaNekretnineService;
    private final NekretninaService nekretninaService;
    private final DrzavaService drzavaService;
    private final TipNekretnineService tipNekretnineService;

    @Autowired
    public MainController(AgentZaNekretnineService agentZaNekretnineService, NekretninaService nekretninaService, DrzavaService drzavaService, TipNekretnineService tipNekretnineService) {
        this.agentZaNekretnineService = agentZaNekretnineService;
        this.nekretninaService = nekretninaService;
        this.drzavaService = drzavaService;
        this.tipNekretnineService = tipNekretnineService;
    }


    @GetMapping(path = "/")
    public String getHomePage(Model model) {
        model.addAttribute("nekretnine", nekretninaService.getAllNekretnina());
        model.addAttribute("agents", agentZaNekretnineService.getAllAgents());
        model.addAttribute("drzave", drzavaService.getAllDrzava());
        return "home";
    }

    @GetMapping(path="/nekretnine")
    public String getNekretnine(Model model) {
        model.addAttribute("nekretnine", nekretninaService.getAllNekretnina());
        model.addAttribute("drzave", drzavaService.getAllDrzava());
        model.addAttribute("tipovi", tipNekretnineService.getAllTipovi());
        model.addAttribute("agents", agentZaNekretnineService.getAllAgents());
        return "nekretnine";
    }

    @GetMapping(path="/agenti")
    public String getAgenti(Model model) {
        model.addAttribute("agents", agentZaNekretnineService.getAllAgents());
        return "agenti";
    }

}
