package com.infosus.prodajanekretnina.services;

import com.infosus.prodajanekretnina.domain.Drzava;
import com.infosus.prodajanekretnina.domain.TipNekretnine;
import com.infosus.prodajanekretnina.repositories.DrzavaRepository;
import com.infosus.prodajanekretnina.repositories.TipNekretnineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipNekretnineService {

    private final TipNekretnineRepository tipNekretnineRepository;

    @Autowired
    public TipNekretnineService(TipNekretnineRepository tipNekretnineRepository) {
        this.tipNekretnineRepository = tipNekretnineRepository;
    }

    public List<TipNekretnine> getAllTipovi() {
        List<TipNekretnine> tipNekretnineList = tipNekretnineRepository.findAll();
        return tipNekretnineList;
    }
}
