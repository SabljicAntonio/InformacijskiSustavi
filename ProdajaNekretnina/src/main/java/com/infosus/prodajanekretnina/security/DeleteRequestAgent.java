package com.infosus.prodajanekretnina.security;

import java.util.Objects;

public class DeleteRequestAgent {
    private String nazivAgenta;

    public DeleteRequestAgent(String nazivAgenta) {
        this.nazivAgenta = nazivAgenta;
    }

    public DeleteRequestAgent() {

    }

    public String getNazivAgenta() {
        return nazivAgenta;
    }

    public void setNazivAgenta(String nazivAgenta) {
        this.nazivAgenta = nazivAgenta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeleteRequestAgent that = (DeleteRequestAgent) o;
        return Objects.equals(nazivAgenta, that.nazivAgenta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazivAgenta);
    }

    @Override
    public String toString() {
        return "DeleteRequestAgent{" +
                "nazivAgenta='" + nazivAgenta + '\'' +
                '}';
    }
}
