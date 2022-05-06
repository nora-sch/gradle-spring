package JPA.ManyToOne.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CiviliteMTO")
public class Civilite{


@Id
private String cle;
private String libelle;

public Civilite() {

	}

 public Civilite(String cle, String libelle) {
	this.cle = cle;
	this.libelle = libelle;
	}

public String getCle() {
	return cle;
}

public void setCle(String cle) {
	this.cle = cle;
}

public String getLibelle() {
	return libelle;
}

public void setLibelle(String libelle) {
	this.libelle = libelle;
}

@Override
public String toString() {
return libelle;
}

}
