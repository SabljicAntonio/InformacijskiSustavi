package com.infosus.prodajanekretnina.requests.agent;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class RegistrationRequestAgent {
    private String ime;
    private String prezime;
    private BigDecimal oib;
    private LocalDate datumRod;
    private String opis;
    private String sifra;
    private String email;
    private Integer prodNek;
    private String nazivAgenta;

    public RegistrationRequestAgent(String ime, String prezime, BigDecimal oib, LocalDate datumRod, String opis, String sifra, String email, Integer prodNek, String nazivAgenta) {
        this.ime = ime;
        this.prezime = prezime;
        this.oib = oib;
        this.datumRod = datumRod;
        this.opis = opis;
        this.sifra = sifra;
        this.email = email;
        this.prodNek = prodNek;
        this.nazivAgenta = nazivAgenta;
        if(this.prodNek == null) this.prodNek = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationRequestAgent that = (RegistrationRequestAgent) o;
        return Objects.equals(ime, that.ime) && Objects.equals(prezime, that.prezime) && Objects.equals(oib, that.oib) && Objects.equals(datumRod, that.datumRod) && Objects.equals(opis, that.opis) && Objects.equals(sifra, that.sifra) && Objects.equals(email, that.email) && Objects.equals(prodNek, that.prodNek) && Objects.equals(nazivAgenta, that.nazivAgenta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ime, prezime, oib, datumRod, opis, sifra, email, prodNek, nazivAgenta);
    }

    @Override
    public String toString() {
        return "RegistrationRequestAgent{" +
                "ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", oib=" + oib +
                ", datumRod=" + datumRod +
                ", opis='" + opis + '\'' +
                ", sifra='" + sifra + '\'' +
                ", email='" + email + '\'' +
                ", prodNek=" + prodNek +
                ", nazivAgenta='" + nazivAgenta + '\'' +
                '}';
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
}
