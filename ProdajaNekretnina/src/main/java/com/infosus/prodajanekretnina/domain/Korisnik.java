package com.infosus.prodajanekretnina.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Table(name = "korisnik", indexes = {
        @Index(name = "korisnik_naziv_kor_key", columnList = "naziv_kor", unique = true),
        @Index(name = "korisnik_email_key", columnList = "email", unique = true)
})
@Entity
public class Korisnik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "korisnik_id", nullable = false)
    private Integer id;

    @Column(name = "naziv_kor", nullable = false, length = 50)
    private String nazivKor;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "sifra", nullable = false, length = 50)
    private String sifra;

    @OneToOne(optional = false)
    @JoinColumn(name = "osoba_id", nullable = false)
    private Osoba osoba;


    public Korisnik(String nazivKor, String email, String sifra, Osoba osoba) {
        this.nazivKor = nazivKor;
        this.email = email;
        this.sifra = sifra;
        this.osoba = osoba;
    }

    public Korisnik() {
    }

    public Osoba getOsoba() {
        return osoba;
    }

    public void setOsoba(Osoba osoba) {
        this.osoba = osoba;
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

    public String getNazivKor() {
        return nazivKor;
    }

    public void setNazivKor(String nazivKor) {
        this.nazivKor = nazivKor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Korisnik{" +
                "nazivKor='" + nazivKor + '\'' +
                ", email='" + email + '\'' +
                ", sifra='" + sifra + '\'' +
                ", osoba=" + osoba +
                '}';
    }

}