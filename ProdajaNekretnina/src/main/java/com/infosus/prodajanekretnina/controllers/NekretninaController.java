package com.infosus.prodajanekretnina.controllers;

import com.infosus.prodajanekretnina.requests.nekretnina.DeleteRequestNekretnina;
import com.infosus.prodajanekretnina.requests.nekretnina.PutRequestNekretnina;
import com.infosus.prodajanekretnina.requests.nekretnina.RegistrationRequestNekretnina;
import com.infosus.prodajanekretnina.services.NekretninaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class NekretninaController {
    private final NekretninaService nekretninaService;

    @Autowired
    public NekretninaController(NekretninaService nekretninaService) {
        this.nekretninaService = nekretninaService;
    }

    @PostMapping(path = "/register1/nekretnina")
    public String dodajNekretnina( RegistrationRequestNekretnina req) {
        String status = nekretninaService.registerNekretnina(req);
        return status;
    }
    @PostMapping(path = "/register/nekretnina")
    public String registerNekretnina(@RequestBody RegistrationRequestNekretnina req) {
        String status = nekretninaService.registerNekretnina(req);
        return status;
    }
    @PostMapping(path= "/delete1/nekretnina")
    public String obrisiNekretnina( DeleteRequestNekretnina req) {
        String status = nekretninaService.deleteNekretnina(req);
        return status;
    }
    @DeleteMapping(path= "/delete/nekretnina")
    public String deleteNekretnina(@RequestBody DeleteRequestNekretnina req) {
        String status = nekretninaService.deleteNekretnina(req);
        return status;
    }

    /**
     * Po nazivNek se gleda koja ce se nekretnina promjenit
     * */
    @PostMapping(path = "/change1/nekretnina")
    public String promjenaNekretnina( PutRequestNekretnina req) {
        String status = nekretninaService.putNekretnina(req);
        return status;
    }
    @PutMapping(path = "/change/nekretnina")
    public String putNekretnina(@RequestBody PutRequestNekretnina req) {
        String status = nekretninaService.putNekretnina(req);
        return status;
    }
}
