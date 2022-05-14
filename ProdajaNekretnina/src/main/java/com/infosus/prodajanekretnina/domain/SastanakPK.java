package com.infosus.prodajanekretnina.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SastanakPK implements Serializable {
    @Column(nullable=false, name = "korisnik_id")
    private Integer korisnikId;
    @Column(nullable=false, name = "agent_id")
    private Integer agentId;
    @Column(nullable=false, name = "nek_id")
    private Integer nekId;

    public SastanakPK(Integer korisnikId, Integer agentId, Integer nekId) {
        this.korisnikId = korisnikId;
        this.agentId = agentId;
        this.nekId = nekId;
    }

    public SastanakPK() {
    }

    public Integer getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(Integer korisnikId) {
        this.korisnikId = korisnikId;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public Integer getNekId() {
        return nekId;
    }

    public void setNekId(Integer nekId) {
        this.nekId = nekId;
    }
}
