package JPA.OneToMany.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="PersonneOTM")
public class Personne{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nom;
	private String prenom;
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval = true) 
	@JoinColumn(name = "Personne_id")
	private List<Adresse> listeAdresses;
	
	public Personne() {
		setListeAdresses(null);
	}
	
	public Personne(String nom, String prenom, List<Adresse> listeAdresses) {
		this.nom = nom;
		this.prenom = prenom;
		setListeAdresses(listeAdresses);
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
		
	public List<Adresse> getListeAdresses() {
		return listeAdresses;
	}

	public void setListeAdresses(List<Adresse> listeAdresses) {
		if(listeAdresses != null) {
			if(this.listeAdresses == null) {
				this.listeAdresses = listeAdresses;
			}
			else {
				this.listeAdresses.clear();
				for(Adresse adresse : listeAdresses) {
					this.listeAdresses.add(adresse);
				}
			}
		}else {
			this.listeAdresses = new ArrayList<>();
		}
	}
	
	@Override
	public String toString() {
	StringBuilder adresses = new StringBuilder();
	for(Adresse adresse : this.listeAdresses) {
		adresses.append("\n");
		adresses.append("* ");
		adresses.append(adresse);
	}
	return "Personne - "+id+": " + prenom +" "+nom+"; \nAdresses :  "+ adresses;
	}
	
	
}
