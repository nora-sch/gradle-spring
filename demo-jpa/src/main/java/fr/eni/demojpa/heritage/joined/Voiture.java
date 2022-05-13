package fr.eni.demojpa.heritage.joined;

import javax.persistence.*;

@Entity(name="voiture_hj")
@Table(name="voiture_hj")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "DISCR")
@DiscriminatorValue(value = "V")

public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String marque;
    public Voiture() {
    }
    public Voiture(String marque) {
        this.marque = marque;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getMarque() {
        return marque;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
    @Override
    public String toString() {
        return "Voiture [id=" + id + ", marque=" + marque + "]";
    }

}
