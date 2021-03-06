package fr.eni.jpa.methode2.entity;

import java.io.Serializable;
import jakarta.persistence.Column;


public class PersonnePK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "NOM", nullable = false, length = 50)
	private String lastname;
	
	@Column(name = "PRENOM", nullable = false, length = 50)
	private String firstname;
	
	public PersonnePK() {
		
	}
	public PersonnePK(String lastname, String firstname) {
		this.lastname = lastname;
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

}
