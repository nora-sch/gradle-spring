package fr.eni.jpa.methode2.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;


@Entity(name="Personne2")
@Table(name="PERSONNE_PK_2")
public class Personne {
	
	@EmbeddedId
	private PersonnePK personnePK;

	
	@Column(name = "AGE", nullable = true)
	@Temporal(TemporalType.DATE)
	private Calendar dateNaissance;
	
	// Transient ne va pas ?tre stock? dans la bdd-  ?a permet que calculer l'?ge de son date de naissance
	@Transient
	private int age;
	
	public Personne() {
		personnePK = new PersonnePK();
		setDateNaissance(null);
	}
	
	public Personne(String nom, String prenom, Calendar dateNaissance) {
		personnePK = new PersonnePK();
		personnePK = new PersonnePK(nom, prenom);
		setDateNaissance(dateNaissance);
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
	return "Personne - : " + personnePK.getFirstname() +" "+personnePK.getLastname()+" n?/e le "+ formattedDate.format(getDateNaissance().getTime());
	}
	
	
}
