package com.infosus.prodajanekretnina.requests.nekretnina;

import java.util.Objects;

public class DeleteRequestNekretnina {
    private String nazivNek;

    public String getNazivNek() {
        return nazivNek;
    }

    public void setNazivNek(String nazivNek) {
        this.nazivNek = nazivNek;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeleteRequestNekretnina that = (DeleteRequestNekretnina) o;
        return Objects.equals(nazivNek, that.nazivNek);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazivNek);
    }

    @Override
    public String toString() {
        return "DeleteRequestNekretnina{" +
                "nazivNek='" + nazivNek + '\'' +
                '}';
    }
}
