package com.infosus.prodajanekretnina.domain;

import org.aspectj.weaver.loadtime.Agent;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AgentZaNekretnineTest {

    @Test
    void getOsoba() {
        Osoba osoba = new Osoba();
        osoba.setDatumRod(LocalDate.now());
        osoba.setId(2);
        osoba.setIme("Ivan");
        osoba.setPrezime("Ivanic");
        osoba.setOib(new BigDecimal(2345678));
        AgentZaNekretnine agent = new AgentZaNekretnine(null, null, null, null, null, osoba);
        assertEquals(osoba, agent.getOsoba());
    }

    @Test
    void setOsoba() {
        Osoba osoba = new Osoba();
        osoba.setDatumRod(LocalDate.now());
        osoba.setId(2);
        osoba.setIme("Ivan");
        osoba.setPrezime("Ivanic");
        osoba.setOib(new BigDecimal(2345678));
        AgentZaNekretnine agent = new AgentZaNekretnine(null, null, null, null, null, null);
        agent.setOsoba(osoba);
        assertEquals(osoba, agent.getOsoba());
    }

}