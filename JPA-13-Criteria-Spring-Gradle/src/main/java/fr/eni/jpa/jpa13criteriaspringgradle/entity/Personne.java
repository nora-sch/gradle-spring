package fr.eni.jpa.jpa13criteriaspringgradle.entity;

import javax.persistence.*;

@Entity
@Table(name="PersonneMTOSpring")
public class Personne{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	
	@ManyToOne
	private Civilite civilite; // pas de cascade!!!!
	
	public Personne() {
	}
	
	public Personne(String nom, String prenom, Civilite civilite) {
		this.nom = nom;
		this.prenom = prenom;
		this.civilite = civilite;
	}
	
	public Personne(int id, String nom, String prenom, Civilite civilite) {
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

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	@Override
	public String toString() {
	return "Personne - "+id+": " + civilite +" "+prenom +" "+nom;
	}
	
	
}
