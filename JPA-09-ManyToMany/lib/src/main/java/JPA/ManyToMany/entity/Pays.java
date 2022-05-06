package JPA.ManyToMany.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PaysMTM")
public class Pays{

@Id
@Column(name="cle")
private String key;
private String libelle;

public Pays() {

	}

 public Pays(String key, String libelle) {
	this.key = key;
	this.libelle = libelle;
	}

public String getKey() {
	return key;
}

public void setKey(String key) {
	this.key = key;
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
