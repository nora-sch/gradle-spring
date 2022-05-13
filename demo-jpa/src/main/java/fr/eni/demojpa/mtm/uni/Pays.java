package fr.eni.demojpa.mtm.uni;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "pays_mtm_u")
@Table(name = "pays_mtm_u")
public class Pays {
    @Id
    private String cle;
    private String libelle;
    public Pays() {
    }
    public Pays(String cle, String libelle) {
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
        return "Pays [cle=" + cle + ", libelle=" + libelle + "]";
    }
}

