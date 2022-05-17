package com.infosus.prodajanekretnina.domain;

import javax.persistence.*;

@Table(name = "drzava", indexes = {
        @Index(name = "drzava_naziv_key", columnList = "naziv", unique = true)
})
@Entity
public class Drzava {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drzava_id", nullable = false)
    private Integer id;

    @Column(name = "naziv", nullable = false, length = 50)
    private String naziv;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Drzava{" +
                "naziv='" + naziv + '\'' +
                '}';
    }
}