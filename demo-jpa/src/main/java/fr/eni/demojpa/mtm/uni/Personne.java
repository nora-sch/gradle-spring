package fr.eni.demojpa.mtm.uni;

import com.eni.demojpa.mto.Civilite;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "personne_mtm_u")
@Table(name = "personne_mtm_u")
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String prenom;
    @ManyToMany(fetch = FetchType.EAGER) //pas cascade
    @JoinTable(name="PersonnePays",
            joinColumns= {@JoinColumn(name="personne_id")},
            inverseJoinColumns= {@JoinColumn(name="paysVisites_id")}
    )
    private List<Pays> paysVisites;
    public Personne() {
        paysVisites = new ArrayList<Pays>();
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
    public List<Pays> getPaysVisites() {return paysVisites;}
    public void setPaysVisites(List<Pays> paysVisites) {this.paysVisites = paysVisites;}
    public void addPaysVisites(Pays a) {paysVisites.add(a);}
    public void removePaysVisites(Pays p) {getPaysVisites().remove(p);}
    @Override
    public String toString() {
        return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" +
                ", paysVisites=" + paysVisites + "]";
    }
}

