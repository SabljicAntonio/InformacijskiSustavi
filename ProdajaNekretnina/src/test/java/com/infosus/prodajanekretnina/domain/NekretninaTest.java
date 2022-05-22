package com.infosus.prodajanekretnina.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class NekretninaTest {

    @Test
    void getTipNekret() {
        TipNekretnine tipNekretnine = new TipNekretnine();
        tipNekretnine.setNazivTipa("Zemlja");
        tipNekretnine.setId(2);
        tipNekretnine.setOpis("Zemljište");
        Nekretnina nek = new Nekretnina("Stancic", "Ulica 1", new BigDecimal("100.00"), 2, "Nova nekretnina", 1000000.00, 2, null, null, tipNekretnine);
        assertEquals(tipNekretnine, nek.getTipNekret());
    }

    @Test
    void setTipNekret() {
        TipNekretnine tipNekretnine = new TipNekretnine();
        tipNekretnine.setNazivTipa("Zemlja");
        tipNekretnine.setId(2);
        tipNekretnine.setOpis("Zemljište");
        Nekretnina nek = new Nekretnina("Stancic", "Ulica 1", new BigDecimal("100.00"), 2, "Nova nekretnina", 1000000.00, 2, null, null, null);
        nek.setTipNekret(tipNekretnine);
        assertEquals(tipNekretnine, nek.getTipNekret());
    }

    @Test
    void getDrzava() {
        Drzava drzava = new Drzava();
        drzava.setId(1);
        drzava.setNaziv("Obala bjelokosti");
        Nekretnina nek = new Nekretnina("Stancic", "Ulica 1", new BigDecimal("100.00"), 2, "Nova nekretnina", 1000000.00, 2, null, drzava, null);
        assertEquals(drzava, nek.getDrzava());
    }

    @Test
    void setDrzava() {
        Drzava drzava = new Drzava();
        drzava.setId(1);
        drzava.setNaziv("Obala bjelokosti");
        Nekretnina nek = new Nekretnina("Stancic", "Ulica 1", new BigDecimal("100.00"), 2, "Nova nekretnina", 1000000.00, 2, null, null, null);
        nek.setDrzava(drzava);
        assertEquals(drzava, nek.getDrzava());
    }

    @Test
    void getAgent() {
        AgentZaNekretnine agent = new AgentZaNekretnine();
        agent.setEmail("agent@nekretnine.hr");
        agent.setNazivAgenta("Ivica");
        agent.setId(1);
        agent.setOpis("Dopustite da Vam pomognem u odabiru idealne nekretnine za Vas!");
        agent.setOsoba(null);
        agent.setSifra("lozinka");
        agent.setProdNek(120);
        Nekretnina nek = new Nekretnina("Stancic", "Ulica 1", new BigDecimal("100.00"), 2, "Nova nekretnina", 1000000.00, 2, agent, null, null);
        assertEquals(agent, nek.getAgent());
    }

    @Test
    void setAgent() {
        AgentZaNekretnine agent = new AgentZaNekretnine();
        agent.setEmail("agent@nekretnine.hr");
        agent.setNazivAgenta("Ivica");
        agent.setId(1);
        agent.setOpis("Dopustite da Vam pomognem u odabiru idealne nekretnine za Vas!");
        agent.setOsoba(null);
        agent.setSifra("lozinka");
        agent.setProdNek(120);
        Nekretnina nek = new Nekretnina("Stancic", "Ulica 1", new BigDecimal("100.00"), 2, "Nova nekretnina", 1000000.00, 2, null, null, null);
        nek.setAgent(agent);
        assertEquals(agent, nek.getAgent());
    }

    @Test
    void getStatus() {
        Nekretnina nek = new Nekretnina("Stancic", "Ulica 1", new BigDecimal("100.00"), 2, "Nova nekretnina", 1000000.00, 2, null, null, null);
        assertEquals(2, nek.getStatus());
    }

    @Test
    void setStatus() {
        Nekretnina nek = new Nekretnina("Stancic", "Ulica 1", new BigDecimal("100.00"), 2, "Nova nekretnina", 1000000.00, 2, null, null, null);
        nek.setStatus(3);
        assertEquals(3, nek.getStatus());
    }

    @Test
    void getCijena() {
        Nekretnina nek = new Nekretnina("Stancic", "Ulica 1", new BigDecimal("100.00"), 2, "Nova nekretnina", 1000000.00, 2, null, null, null);
        assertEquals(1000000.00, nek.getCijena());
    }

    @Test
    void setCijena() {
        Nekretnina nek = new Nekretnina("Stancic", "Ulica 1", new BigDecimal("100.00"), 2, "Nova nekretnina", 1000000.00, 2, null, null, null);
        nek.setCijena(200000.00);
        assertEquals(200000.00, nek.getCijena());
    }

    @Test
    void getOpis() {
        Nekretnina nek = new Nekretnina("Stancic", "Ulica 1", new BigDecimal("100.00"), 2, "Nova nekretnina", 1000000.00, 2, null, null, null);
        assertTrue("Nova nekretnina".equals(nek.getOpis()));
    }

    @Test
    void setOpis() {
        Nekretnina nek = new Nekretnina("Stancic", "Ulica 1", new BigDecimal("100.00"), 2, "Nova nekretnina", 1000000.00, 2, null, null, null);
        nek.setOpis("Novi stan");
        assertTrue("Novi stan".equals(nek.getOpis()));
    }

    @Test
    void getOcjena() {
        Nekretnina nek = new Nekretnina("Stancic", "Ulica 1", new BigDecimal("100.00"), 2, "Nova nekretnina", 1000000.00, 2, null, null, null);
        assertEquals(2, nek.getOcjena());
    }

    @Test
    void setOcjena() {
        Nekretnina nek = new Nekretnina("Stancic", "Ulica 1", new BigDecimal("100.00"), 2, "Nova nekretnina", 1000000.00, 2, null, null, null);
        nek.setOcjena(3);
        assertEquals(3, nek.getOcjena());
    }

    @Test
    void getPovrsina() {
        Nekretnina nek = new Nekretnina("Stancic", "Ulica 1", new BigDecimal("100.00"), 2, "Nova nekretnina", 1000000.00, 2, null, null, null);
        BigDecimal bd = new BigDecimal("100.00");
        assertEquals(bd, nek.getPovrsina());


    }

    @Test
    void setPovrsina() {
        Nekretnina nek = new Nekretnina("Stancic", "Ulica 1", new BigDecimal("100.00"), 2, "Nova nekretnina", 1000000.00, 2, null, null, null);
        BigDecimal bd = new BigDecimal("112.00");
        nek.setPovrsina(bd);
        assertEquals(bd, nek.getPovrsina());
    }

    @Test
    void getAdresa() {
        Nekretnina nek = new Nekretnina("Stancic", "Ulica 1", new BigDecimal("100.00"), 2, "Nova nekretnina", 1000000.00, 2, null, null, null);
        assertTrue("Ulica 1".equals(nek.getAdresa()));
    }

    @Test
    void setAdresa() {
        Nekretnina nek = new Nekretnina("Stancic", "Ulica 1", new BigDecimal("100.00"), 2, "Nova nekretnina", 1000000.00, 2, null, null, null);
        nek.setAdresa("Ulica 2");
        assertTrue("Ulica 2".equals(nek.getAdresa()));
    }

    @Test
    void getNazivNek() {
        Nekretnina nek = new Nekretnina("Stancic", "Ulica 1", new BigDecimal("100.00"), 2, "Nova nekretnina", 1000000.00, 2, null, null, null);
        assertTrue("Stancic".equals(nek.getNazivNek()));
    }

    @Test
    void setNazivNek() {
        Nekretnina nek = new Nekretnina("Stancic", "Ulica 1", new BigDecimal("100.00"), 2, "Nova nekretnina", 1000000.00, 2, null, null, null);
        nek.setNazivNek("Stan");
        assertTrue("Stan".equals(nek.getNazivNek()));
    }

    @Test
    void getId() {
        Nekretnina nek = new Nekretnina("Stancic", "Ulica 1", new BigDecimal("100.00"), 2, "Nova nekretnina", 1000000.00, 2, null, null, null);
        assertEquals(nek.getId(), null);
    }

    @Test
    void setId() {
        Nekretnina nek = new Nekretnina("Stancic", "Ulica 1", new BigDecimal("100.00"), 2, "Nova nekretnina", 1000000.00, 2, null, null, null);
        nek.setId(1);
        assertEquals(1, nek.getId());
    }

    @Test
    void testToString() {
        Nekretnina nek = new Nekretnina("Stancic", "Ulica 1", new BigDecimal("100.00"), 2, "Nova nekretnina", 1000000.00, 2, null, null, null);
        String output="Nekretnina{" +
                "nazivNek='" + "Stancic" + '\'' +
                ", adresa='" + "Ulica 1" + '\'' +
                ", povrsina=" + new BigDecimal("100.00") +
                ", ocjena=" + 2 +
                ", opis='" + "Nova nekretnina" + '\'' +
                ", cijena=" + 1000000.00 +
                ", status=" + 2 +
                ", agent=" + null +
                ", drzava=" + null +
                ", tipNekret=" + null +
                '}';
        assertTrue(output.equals(nek.toString()));
    }
}