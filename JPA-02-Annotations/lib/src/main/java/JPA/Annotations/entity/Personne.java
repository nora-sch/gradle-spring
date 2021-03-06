package JPA.Annotations.entity;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;



@Entity
@Table(name="PERSONNES")
public class Personne implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@Column(name = "NOM", nullable = false, length = 50)
	private String nom;
	@Column(name = "PRENOM", nullable = false, length = 50)
	private String prenom;
	@Column(name = "DATE_NAISSANCE", nullable = true)
	@Temporal(TemporalType.DATE)
	private Calendar dateNaissance;
	// Transient ne va pas ?tre stock? dans la bdd-  ?a permet que calculer l'?ge de son date de naissance
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

	public Calendar getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Calendar dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	@Override
	public String toString() {
	SimpleDateFormat formattedDate = new SimpleDateFormat("dd/MM/yyyy");
	return "Personne - "+this.getId()+": " + this.getPrenom() +" "+this.getNom()+" n?/e le "+ formattedDate.format(getDateNaissance().getTime());
	}
	
	
}
