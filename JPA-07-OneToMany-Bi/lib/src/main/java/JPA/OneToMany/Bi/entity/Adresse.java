package JPA.OneToMany.Bi.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="AdresseOTMBi")
public class Adresse implements Serializable {

private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;

private String codePostal;
private String ville;

@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
private Personne personne;

public Adresse(String codePostal, String ville) {
	this.codePostal = codePostal;
	this.ville = ville;
	}

public Adresse(String codePostal, String ville, Personne personne) {
	this.codePostal = codePostal;
	this.ville = ville;
	this.personne = personne;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getVille() {
	return ville;
}

public void setVille(String ville) {
	this.ville = ville;
}

public String getCodePostal() {
	return codePostal;
}

public void setCodePostal(String codePostal) {
	this.codePostal = codePostal;
}
 
public Personne getPersonne() {
	return personne;
}

public void setPersonne(Personne personne) {
	this.personne = personne;
}

@Override
public String toString() {
return ville + " CP-"+ codePostal;
}

}
