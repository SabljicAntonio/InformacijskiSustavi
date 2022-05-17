package com.infosus.prodajanekretnina.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "osoba", indexes = {
        @Index(name = "osoba_oib_key", columnList = "oib", unique = true)
})
@Entity
public class Osoba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "osoba_id", nullable = false)
    private Integer id;

    @Column(name = "oib", nullable = false, unique = true, precision = 11)
    private BigDecimal oib;

    @Column(name = "ime", nullable = false, length = 50)
    private String ime;

    @Column(name = "prezime", nullable = false, length = 50)
    private String prezime;

    @Column(name = "datum_rod", nullable = false)
    private LocalDate datumRod;

    public Osoba(BigDecimal oib, String ime, String prezime, LocalDate datumRod) {
        this.oib = oib;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRod = datumRod;
    }

    public Osoba() {
    }

    public LocalDate getDatumRod() {
        return datumRod;
    }

    public void setDatumRod(LocalDate datumRod) {
        this.datumRod = datumRod;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public BigDecimal getOib() {
        return oib;
    }

    public void setOib(BigDecimal oib) {
        this.oib = oib;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "oib=" + oib +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", datumRod=" + datumRod +
                '}';
    }
}