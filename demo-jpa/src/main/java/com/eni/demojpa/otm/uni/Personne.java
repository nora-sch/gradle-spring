package com.eni.demojpa.otm.uni;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "personne_OTM_u")
@Table(name = "personne_OTM_u")
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String prenom;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "personne_id")
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
    public void setAdresses(List<Adresse> adresses) {this.adresses = adresses;}
    public void addAdresse(Adresse a) {
        System.out.println(a);
        System.out.println(adresses);
    adresses.add(a);}

    @Override
    public String toString() {
        return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" +
                ", adresses=" + adresses + "]";
    }
}

