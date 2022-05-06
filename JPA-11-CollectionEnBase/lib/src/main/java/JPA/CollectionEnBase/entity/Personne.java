package JPA.CollectionEnBase.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="PersonneCollection")
public class Personne implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	
	@ElementCollection
	@CollectionTable(name = "Sports", joinColumns = @JoinColumn(name="id_spo", referencedColumnName = "id"))
	@Column(name = "sport")
	List<String> sports;

	public Personne(String nom, String prenom, List<String> sports) {
		this.nom = nom;
		this.prenom = prenom;
		this.sports = sports;
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

	public List<String> getSports() {
		return sports;
	}

	public void setSports(List<String> sports) {
		this.sports = sports;
	}

	@Override
	public String toString() {
	StringBuilder listeSports = new StringBuilder();
	for(String sport : this.sports) {
		listeSports.append("\n");
		listeSports.append("* ");
		listeSports.append(sport);
	}
	return "Personne - "+id+": " + prenom +" "+nom+"; \nSports :  "+ listeSports;
	}
	


}
	
	

