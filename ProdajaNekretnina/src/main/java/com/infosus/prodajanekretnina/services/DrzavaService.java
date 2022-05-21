package com.infosus.prodajanekretnina.services;

import com.infosus.prodajanekretnina.domain.Drzava;
import com.infosus.prodajanekretnina.repositories.DrzavaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrzavaService {

    private final DrzavaRepository drzavaRepository;

    @Autowired
    public DrzavaService(DrzavaRepository drzavaRepository) {
        this.drzavaRepository = drzavaRepository;
    }

    public List<Drzava> getAllDrzava() {
        List<Drzava> drzaveList = drzavaRepository.findAll();
        return drzaveList;
    }
}
