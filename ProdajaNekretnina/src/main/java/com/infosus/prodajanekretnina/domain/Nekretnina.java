package com.infosus.prodajanekretnina.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "nekretnina", indexes = {
        @Index(name = "nekretnina_adresa_key", columnList = "adresa", unique = true)
})
@Entity
public class Nekretnina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nek_id", nullable = false)
    private Integer id;

    @Column(name = "naziv_nek", nullable = false, length = 50)
    private String nazivNek;

    @Column(name = "adresa", nullable = false, length = 50)
    private String adresa;

    @Column(name = "povrsina", nullable = false, precision = 10, scale = 2)
    private BigDecimal povrsina;

    @Column(name = "ocjena")
    private Integer ocjena;

    @Column(name = "opis", length = 500)
    private String opis;

    @Column(name = "cijena", nullable = false)
    private Double cijena;

    @Column(name = "status", nullable = false)
    private Integer status;

    @ManyToOne(optional = false)
    @JoinColumn(name = "agent_id", nullable = false)
    private AgentZaNekretnine agent;

    @ManyToOne(optional = false)
    @JoinColumn(name = "drzava_id", nullable = false)
    private Drzava drzava;

    @ManyToOne(optional = false)
    @JoinColumn(name = "tip_nekret_id", nullable = false)
    private TipNekretnine tipNekret;

    public TipNekretnine getTipNekret() {
        return tipNekret;
    }

    public void setTipNekret(TipNekretnine tipNekret) {
        this.tipNekret = tipNekret;
    }

    public Drzava getDrzava() {
        return drzava;
    }

    public void setDrzava(Drzava drzava) {
        this.drzava = drzava;
    }

    public AgentZaNekretnine getAgent() {
        return agent;
    }

    public void setAgent(AgentZaNekretnine agent) {
        this.agent = agent;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getCijena() {
        return cijena;
    }

    public void setCijena(Double cijena) {
        this.cijena = cijena;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Integer getOcjena() {
        return ocjena;
    }

    public void setOcjena(Integer ocjena) {
        this.ocjena = ocjena;
    }

    public BigDecimal getPovrsina() {
        return povrsina;
    }

    public void setPovrsina(BigDecimal povrsina) {
        this.povrsina = povrsina;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getNazivNek() {
        return nazivNek;
    }

    public void setNazivNek(String nazivNek) {
        this.nazivNek = nazivNek;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Nekretnina{" +
                "nazivNek='" + nazivNek + '\'' +
                ", adresa='" + adresa + '\'' +
                ", povrsina=" + povrsina +
                ", ocjena=" + ocjena +
                ", opis='" + opis + '\'' +
                ", cijena=" + cijena +
                ", status=" + status +
                ", agent=" + agent +
                ", drzava=" + drzava +
                ", tipNekret=" + tipNekret +
                '}';
    }
}