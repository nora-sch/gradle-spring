package com.eni.demojpa.key1;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "personne_pk_1")
@IdClass(PersonnePK.class)
@Table(name = "personne_pk_1")
public class Personne {
    @Id
    private String nom;
    @Id
    private String prenom;
    private LocalDate dateNaissance;
    @Transient
    private int age;
    public Personne() {
    }
    public Personne(String nom, String prenom, LocalDate dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
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
    public void setPrenom(String prénom) {
        this.prenom = prénom;
    }
    public LocalDate getDateNaissance() {
        return dateNaissance;
    }
    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Personne [nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance +
                ", age=" + age
                + "]";
    }
}
