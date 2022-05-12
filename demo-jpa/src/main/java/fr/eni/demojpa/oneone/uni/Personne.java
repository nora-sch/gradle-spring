package fr.eni.demojpa.oneone.uni;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "personne_OTO_u")
@Table(name = "personne_OTO_u")
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    @Transient
    private int age;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Adresse adresse;

    public Personne() {
    }
    public Personne(String nom, String prenom, LocalDate dateNaissance, Adresse adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
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
    public long getId() {return id;}
    public void setId(long id) {this.id = id;}
    public Adresse getAdresse() {return adresse;}
    public void setAdresse(Adresse adresse) {this.adresse = adresse;}

    @Override
    public String toString() {
        return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" +
                dateNaissance
                + ", age=" + age + ", adresse=" + adresse + "]";
    }
}



