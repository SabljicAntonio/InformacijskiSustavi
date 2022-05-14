package com.infosus.prodajanekretnina.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Table(name = "sastanak", indexes = {
        @Index(name = "sastanak_vrijeme_korisnik_id_agent_id_key", columnList = "vrijeme, korisnik_id, agent_id", unique = true)
})
@Entity
public class Sastanak {

    @EmbeddedId
    private SastanakPK sastanakPK;

    @Column(name = "vrijeme", nullable = false)
    private Instant vrijeme;

    public Sastanak(SastanakPK sastanakPK, Instant vrijeme) {
        this.sastanakPK = sastanakPK;
        this.vrijeme = vrijeme;
    }

    public Sastanak() {
    }

    public SastanakPK getSastanakPK() {
        return sastanakPK;
    }

    public void setSastanakPK(SastanakPK sastanakPK) {
        this.sastanakPK = sastanakPK;
    }

    public Instant getVrijeme() {
        return vrijeme;
    }

    public void setVrijeme(Instant vrijeme) {
        this.vrijeme = vrijeme;
    }
}