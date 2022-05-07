package JPA.JPQL.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name="PersonneMTO")

@NamedQueries({
	@NamedQuery(name = "findTous", query = "SELECT p FROM Personne p"),
	@NamedQuery(name = "findNomCommencePar", query = "SELECT p FROM Personne p WHERE p.nom LIKE :var"),
	@NamedQuery(name = "findMessieurs", query = "SELECT p FROM Personne p WHERE p.civilite.cle='M'"),
})
public class Personne implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	
	@ManyToOne
	private Civilite civilite;

	public Personne(){
	}
	public Personne(String nom, String prenom, Civilite civilite){
		this.nom = nom;
		this.prenom = prenom;
		this.civilite = civilite;
	}
	public Personne(int id, String nom, String prenom, Civilite civilite){
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.civilite = civilite;
	}

		public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	

	@Override
	public String toString() {
 	return "Personne - "+id+": "+civilite+" " + prenom +" "+nom;
	}
	


}
	
	

