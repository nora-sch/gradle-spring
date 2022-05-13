package com.eni.demojpa.key2;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "personne_pk_2")
@Table(name = "personne_pk_2")
public class Personne {
    @EmbeddedId
    private PersonnePK personnePK;
    private LocalDate dateNaissance;
    @Transient
    private int age;
    public Personne() {
    }
    public Personne(String nom, String prenom, LocalDate dateNaissance) {
        personnePK = new PersonnePK();
        personnePK.setNom(prenom);
        personnePK.setPrenom(nom);
        this.dateNaissance = dateNaissance;
    }
    public String getPrenom() {
        return personnePK.getPrenom();
    }
    public String getNom() {
        return personnePK.getNom();
    }
    public PersonnePK getPersonnePK() {
        return personnePK;
    }

    public void setPersonnePK(PersonnePK personnePK) {
        this.personnePK = personnePK;
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
        return "Personne [nom=" + getNom() + ", prenom=" + getPrenom() + ", dateNaissance=" + dateNaissance +
                ", age=" + age
                + "]";
    }
}
