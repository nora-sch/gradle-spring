package com.eni.demojpa.otm.bi;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "personne_OTM_bi")
@Table(name = "personne_OTM_bi")
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String prenom;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "personne")
    private List<Adresse> adresses;

    public Personne() {
        adresses = new ArrayList<Adresse>();
    }
    public Personne(String nom, String prenom) {
        this();
        this.nom = nom;
        this.prenom = prenom;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public long getId() {return id;}
    public void setId(long id) {this.id = id;}
    public List<Adresse> getAdresses() {return adresses;}
    public void setAdresses(List<Adresse> adresses) {
        this.adresses = adresses;
        //Gestion bidirectionnelle
        for (Adresse a : this.adresses) {
            a.setPersonne(this);
        }
    }
    public void addAdresse(Adresse a) {
        adresses.add(a);
        //Gestion bidirectionnelle
        a.setPersonne(this);
    }

    @Override
    public String toString() {
        return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" +
                ", adresses=" + adresses + "]";
    }
}

