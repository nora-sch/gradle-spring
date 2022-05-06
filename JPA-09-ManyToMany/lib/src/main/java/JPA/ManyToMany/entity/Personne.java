package JPA.ManyToMany.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="PersonneMTM")
public class Personne implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	
	@ManyToMany  // pas de cascade, car on ne supprime pas des pays
	@JoinTable(name="PersonnePays", 
			joinColumns = {@JoinColumn(name="personneId")},
			inverseJoinColumns = {@JoinColumn(name="paysId")})
	private List<Pays> paysVisites;
	
	public Personne() {
		setPaysVisites(null);
	}
	
	public Personne(String nom, String prenom, List<Pays> paysVisites) {
		this.nom = nom;
		this.prenom = prenom;
		setPaysVisites(paysVisites);
	}

	public Personne(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
		setPaysVisites(null);
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

	public List<Pays> getPaysVisites() {
		return paysVisites;
	}

	private void setPaysVisites(List<Pays> listePays) {
		if(listePays != null) {
			if(this.paysVisites == null) {
				this.paysVisites = listePays;
			}
			else {
				this.paysVisites.clear();
				for(Pays pays : listePays) {
					this.paysVisites.add(pays);
				}
			}
		}else {
			this.paysVisites = new ArrayList<>();
		}
	}
	
	public void addPaysVisite(Pays pays) {
		if(this.paysVisites == null) {
		this.paysVisites = new ArrayList<>();
			}	
		this.paysVisites.add(pays);
	}
	
	
	public void removePaysVisite(Pays pays) {
		if(this.paysVisites.contains(pays)) {
			this.paysVisites.remove(pays);
			System.out.println("Pays "+pays+" supprimé de la liste");
			}	
	}
		
	@Override
	public String toString() {
	StringBuilder countries = new StringBuilder();
	for(Pays pays : this.paysVisites) {
		countries.append("\n");
		countries.append("* ");
		countries.append(pays);
	}
	return "Personne - "+id+": " + prenom +" "+nom+"; \nPays visitées :  "+ countries;
	}
	


}
	
	

