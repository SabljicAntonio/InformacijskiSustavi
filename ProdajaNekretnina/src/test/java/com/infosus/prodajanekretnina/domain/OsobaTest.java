package com.infosus.prodajanekretnina.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class OsobaTest {

    @Test
    void getPrezime() {
        Osoba osoba = new Osoba(null, null, "Ivic", null);
        assertTrue("Ivic".equals(osoba.getPrezime()));
    }

    @Test
    void setPrezime() {
        Osoba osoba = new Osoba(null, null, "Ivic", null);
        osoba.setPrezime("Horvat");
        assertTrue("Horvat".equals(osoba.getPrezime()));
    }

    @Test
    void getIme() {
        Osoba osoba = new Osoba(null, "Ivo", "Ivic", null);
        assertTrue("Ivo".equals(osoba.getIme()));
    }

    @Test
    void setIme() {
        Osoba osoba = new Osoba(null, null, "Ivic", null);
        osoba.setIme("Ivo");
        assertTrue("Ivo".equals(osoba.getIme()));
    }

}