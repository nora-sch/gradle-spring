package com.eni.demojpa.heritage.singletable;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
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
