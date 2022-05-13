package com.eni.demojpa.mto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "civilite_mto")
@Table(name = "civilite_mto")
public class Civilite {
    @Id
    private String cle;
    private String libelle;
    public Civilite() {
    }
    public Civilite(String cle, String libelle) {
        this.cle = cle;
        this.libelle = libelle;
    }
    public String getCle() {
        return cle;
    }
    public void setCle(String cle) {
        this.cle = cle;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    @Override
    public String toString() {
        return "Civilite [cle=" + cle + ", libelle=" + libelle + "]";
    }

}
