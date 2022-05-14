package com.infosus.prodajanekretnina.domain;

import javax.persistence.*;

@Table(name = "tip_nekret", indexes = {
        @Index(name = "tip_nekret_naziv_tipa_key", columnList = "naziv_tipa", unique = true)
})
@Entity
public class TipNekretnine {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "tip_nekret_id", nullable = false)
    private Integer id;

    @Column(name = "naziv_tipa", nullable = false, length = 50)
    private String nazivTipa;

    @Column(name = "opis", length = 400)
    private String opis;

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getNazivTipa() {
        return nazivTipa;
    }

    public void setNazivTipa(String nazivTipa) {
        this.nazivTipa = nazivTipa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TipNekretnine{" +
                "nazivTipa='" + nazivTipa + '\'' +
                ", opis='" + opis + '\'' +
                '}';
    }
}