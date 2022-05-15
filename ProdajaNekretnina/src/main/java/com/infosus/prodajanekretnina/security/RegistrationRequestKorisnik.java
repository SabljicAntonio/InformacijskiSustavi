package com.infosus.prodajanekretnina.security;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class RegistrationRequestKorisnik {
    private String ime;
    private String prezime;
    private BigDecimal oib;
    private LocalDate datumRod;
    private String nazivKor;
    private String email;
    private String sifra;

    public RegistrationRequestKorisnik(String ime, String prezime, BigDecimal oib, LocalDate datumRod, String nazivKor, String email, String sifra) {
        this.ime = ime;
        this.prezime = prezime;
        this.oib = oib;
        this.datumRod = datumRod;
        this.nazivKor = nazivKor;
        this.email = email;
        this.sifra = sifra;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public BigDecimal getOib() {
        return oib;
    }

    public void setOib(BigDecimal oib) {
        this.oib = oib;
    }

    public LocalDate getDatumRod() {
        return datumRod;
    }

    public void setDatumRod(LocalDate datumRod) {
        this.datumRod = datumRod;
    }

    public String getNazivKor() {
        return nazivKor;
    }

    public void setNazivKor(String nazivKor) {
        this.nazivKor = nazivKor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationRequestKorisnik that = (RegistrationRequestKorisnik) o;
        return Objects.equals(ime, that.ime) && Objects.equals(prezime, that.prezime) && Objects.equals(oib, that.oib) && Objects.equals(datumRod, that.datumRod) && Objects.equals(nazivKor, that.nazivKor) && Objects.equals(email, that.email) && Objects.equals(sifra, that.sifra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ime, prezime, oib, datumRod, nazivKor, email, sifra);
    }

    @Override
    public String toString() {
        return "RegistrationRequestKorisnik{" +
                "ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", oib=" + oib +
                ", datumRod=" + datumRod +
                ", nazivKor='" + nazivKor + '\'' +
                ", email='" + email + '\'' +
                ", sifra='" + sifra + '\'' +
                '}';
    }
}

