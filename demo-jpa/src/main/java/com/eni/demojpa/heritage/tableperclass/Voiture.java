package com.eni.demojpa.heritage.tableperclass;

import javax.persistence.*;

@Entity(name="voiture_tpc")
@Table(name="voiture_tpc")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
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
