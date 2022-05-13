package com.eni.demojpa.heritage.singletable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "B")
public class Berline extends Voiture{
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
