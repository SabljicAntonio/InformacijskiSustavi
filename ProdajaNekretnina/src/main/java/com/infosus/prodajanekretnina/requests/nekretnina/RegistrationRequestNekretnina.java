package com.infosus.prodajanekretnina.requests.nekretnina;

import java.math.BigDecimal;
import java.util.Objects;

public class RegistrationRequestNekretnina {
    private String nazivNek;
    private String adresa;
    private BigDecimal povrsina;
    private Integer ocjena;
    private String opis;
    private Double cijena;
    private Integer status;
    private String nazivAgenta;
    private String drzava;
    private String tipNek;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationRequestNekretnina that = (RegistrationRequestNekretnina) o;
        return Objects.equals(nazivNek, that.nazivNek) && Objects.equals(adresa, that.adresa) && Objects.equals(povrsina, that.povrsina) && Objects.equals(ocjena, that.ocjena) && Objects.equals(opis, that.opis) && Objects.equals(cijena, that.cijena) && Objects.equals(status, that.status) && Objects.equals(nazivAgenta, that.nazivAgenta) && Objects.equals(drzava, that.drzava) && Objects.equals(tipNek, that.tipNek);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazivNek, adresa, povrsina, ocjena, opis, cijena, status, nazivAgenta, drzava, tipNek);
    }

    @Override
    public String toString() {
        return "RegistrationRequestNekretnina{" +
                "nazivNek='" + nazivNek + '\'' +
                ", adresa='" + adresa + '\'' +
                ", povrsina=" + povrsina +
                ", ocjena=" + ocjena +
                ", opis='" + opis + '\'' +
                ", cijena=" + cijena +
                ", status=" + status +
                ", nazivAgenta='" + nazivAgenta + '\'' +
                ", drzava='" + drzava + '\'' +
                ", tipNek='" + tipNek + '\'' +
                '}';
    }

    public String getNazivNek() {
        return nazivNek;
    }

    public void setNazivNek(String nazivNek) {
        this.nazivNek = nazivNek;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public BigDecimal getPovrsina() {
        return povrsina;
    }

    public void setPovrsina(BigDecimal povrsina) {
        this.povrsina = povrsina;
    }

    public Integer getOcjena() {
        return ocjena;
    }

    public void setOcjena(Integer ocjena) {
        this.ocjena = ocjena;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Double getCijena() {
        return cijena;
    }

    public void setCijena(Double cijena) {
        this.cijena = cijena;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNazivAgenta() {
        return nazivAgenta;
    }

    public void setNazivAgenta(String nazivAgenta) {
        this.nazivAgenta = nazivAgenta;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public String getTipNek() {
        return tipNek;
    }

    public void setTipNek(String tipNek) {
        this.tipNek = tipNek;
    }
}
