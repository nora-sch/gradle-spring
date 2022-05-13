package fr.eni.demojpa.mtm.bi;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "pays_mtm_bi")
@Table(name = "pays_mtm_bi")
public class Pays {
    @Id
    private String cle;
    private String libelle;
    @ManyToMany(mappedBy="paysVisites", fetch = FetchType.EAGER)
    private List<Personne> personnes;
    public Pays() {
        personnes = new ArrayList<Personne>();
    }
    public Pays(String cle, String libelle) {
        this();
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
    public List<Personne> getPersonnes() {return personnes;}
    public void setPersonnes(List<Personne> personnes) {this.personnes = personnes;}
    //Gestion de la bidirectionnalité
    public void addPersonne(Personne personne) {
        if(!this.personnes.contains(personne)){
            this.personnes.add(personne);
        }
    }

    @Override
    public String toString() {
        return "Pays [cle=" + cle + ", libelle=" + libelle + "]";
    }
}

