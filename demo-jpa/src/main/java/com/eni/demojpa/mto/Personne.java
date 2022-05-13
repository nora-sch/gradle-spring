package com.eni.demojpa.mto;

import javax.persistence.*;

@Entity(name = "personne_mto")
@Table(name = "personne_mto")
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String prenom;
    @ManyToOne
    private Civilite civilite;
    public Personne() {
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
    public Civilite getCivilite() {return civilite;}
    public void setCivilite(Civilite civilite) {this.civilite = civilite;}

    @Override
    public String toString() {
        return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" +
                ", civilite=" + civilite + "]";
    }
}

