package fr.eni.demojpa.heritage.joined;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="berline_hj")
@Table(name="berline_hj")
@DiscriminatorValue(value = "B")
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
