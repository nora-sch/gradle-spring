package fr.eni.demojpa.collections;

import com.eni.demojpa.otm.uni.Adresse;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "personne_cb")
@Table(name = "personne_cb")
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String prenom;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Sports", joinColumns = @JoinColumn(name = "id_spo", referencedColumnName
            = "id"))
    private List<String> sports;

    public Personne() {
        sports = new ArrayList<String>();
    }
    public Personne(String nom, String prenom) {
        this();
        this.nom = nom;
        this.prenom = prenom;
    }
    public void addSport(String sport) {sports.add(sport);}
    public List<String> getSports() {return sports;}
    public void setSports(List<String> sports) {this.sports = sports;}
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


    @Override
    public String toString() {
        return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" +
                ", sports=" + sports + "]";
    }
}

