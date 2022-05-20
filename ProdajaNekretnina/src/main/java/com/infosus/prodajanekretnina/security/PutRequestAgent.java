package com.infosus.prodajanekretnina.security;

import java.util.Objects;

public class PutRequestAgent {
    private String nazivAgenta;
    private String noviNazivAgenta;
    private Integer prodNek;
    private String email;
    private String sifra;
    private String opis;

    @Override
    public String toString() {
        return "PutRequestAgent{" +
                "nazivAgenta='" + nazivAgenta + '\'' +
                ", prodNek=" + prodNek +
                ", email='" + email + '\'' +
                ", sifra='" + sifra + '\'' +
                ", opis='" + opis + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PutRequestAgent that = (PutRequestAgent) o;
        return Objects.equals(nazivAgenta, that.nazivAgenta) && Objects.equals(prodNek, that.prodNek) && Objects.equals(email, that.email) && Objects.equals(sifra, that.sifra) && Objects.equals(opis, that.opis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazivAgenta, prodNek, email, sifra, opis);
    }

    public String getNazivAgenta() {
        return nazivAgenta;
    }

    public void setNazivAgenta(String nazivAgenta) {
        this.nazivAgenta = nazivAgenta;
    }

    public Integer getProdNek() {
        return prodNek;
    }

    public void setProdNek(Integer prodNek) {
        this.prodNek = prodNek;
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

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getNoviNazivAgenta() {
        return noviNazivAgenta;
    }

    public void setNoviNazivAgenta(String noviNazivAgenta) {
        this.noviNazivAgenta = noviNazivAgenta;
    }
}
