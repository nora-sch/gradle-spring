package fr.eni.jpa.methode1.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity(name="Personne1")
@IdClass(PersonnePK.class)
@Table(name="PERSONNE_PK_1")
public class Personne {

	@Id
	@Column(name = "NOM", nullable = false, length = 50)
	private String nom;

	@Id
	@Column(name = "PRENOM", nullable = false, length = 50)
	private String prenom;
	@Column(name = "DATE_NAISSANCE", nullable = true)
	@Temporal(TemporalType.DATE)
	private Calendar dateNaissance;
	// Transient ne va pas être stocké dans la bdd-  ça permet que calculer l'âge de son date de naissance
	@Transient
	private int age;
	
	public Personne() {
		setDateNaissance(null);
	}
	
	public Personne(String nom, String prenom, Calendar dateNaissance) {
		setNom(nom);
		setPrenom(prenom);
		setDateNaissance(dateNaissance);
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

	public Calendar getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Calendar dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	@Override
	public String toString() {
	SimpleDateFormat formattedDate = new SimpleDateFormat("dd/MM/yyyy");
	return "Personne - : " + this.getPrenom() +" "+this.getNom()+" né/e le "+ formattedDate.format(getDateNaissance().getTime());
	}
	
	
}
