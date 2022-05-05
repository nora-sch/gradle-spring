package JPA.OneToMany.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="AdresseOTM")
public class Adresse {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;

private String codePostal;
private String ville;

public Adresse() {		
	
}
	
public Adresse(String codePostal, String ville) {
	this.codePostal = codePostal;
	this.ville = ville;
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
 
@Override
public String toString() {
return ville + " CP-"+ codePostal;
}

}
