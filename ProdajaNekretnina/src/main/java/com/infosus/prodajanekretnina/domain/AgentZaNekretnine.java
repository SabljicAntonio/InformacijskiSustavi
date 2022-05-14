package com.infosus.prodajanekretnina.domain;

import javax.persistence.*;

@Table(name = "agent_za_nek", indexes = {
        @Index(name = "agent_za_nek_email_key", columnList = "email", unique = true),
        @Index(name = "agent_za_nek_naziv_agenta_key", columnList = "naziv_agenta", unique = true)
})
@Entity
public class AgentZaNekretnine {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "agent_id", nullable = false)
    private Integer id;

    @Column(name = "naziv_agenta", nullable = false, length = 50)
    private String nazivAgenta;

    @Column(name = "prod_nek", nullable = false)
    private Integer prodNek;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "sifra", nullable = false, length = 50)
    private String sifra;

    @Column(name = "opis", length = 400)
    private String opis;

    @OneToOne(optional = false)
    @JoinColumn(name = "osoba_id", nullable = false)
    private Osoba osoba;

    public Osoba getOsoba() {
        return osoba;
    }

    public void setOsoba(Osoba osoba) {
        this.osoba = osoba;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getProdNek() {
        return prodNek;
    }

    public void setProdNek(Integer prodNek) {
        this.prodNek = prodNek;
    }

    public String getNazivAgenta() {
        return nazivAgenta;
    }

    public void setNazivAgenta(String nazivAgenta) {
        this.nazivAgenta = nazivAgenta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AgentZaNekretnine{" +
                "nazivAgenta='" + nazivAgenta + '\'' +
                ", prodNek=" + prodNek +
                ", email='" + email + '\'' +
                ", sifra='" + sifra + '\'' +
                ", opis='" + opis + '\'' +
                ", osoba=" + osoba +
                '}';
    }
}