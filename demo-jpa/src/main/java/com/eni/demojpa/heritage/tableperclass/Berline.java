package com.eni.demojpa.heritage.tableperclass;

import javax.persistence.Entity;

@Entity
public class Berline extends Voiture {
    private String couleurCuir;
    public Berline() {
    }
    public Berline(String marque, String couleurCuir) {
        super(marque);
        this.couleurCuir = couleurCuir;
    }
    public String getCouleurCuir() {
        return couleurCuir;
    }
    public void setCouleurCuir(String couleurCuir) {
        this.couleurCuir = couleurCuir;
    }
    @Override
    public String toString() {
        return "Berline [couleurCuir=" + couleurCuir + "]";
    }

}
