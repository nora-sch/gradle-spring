package JPA.TP1.GestionDeLivres.entity;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="LivreJPA")
public class Livre implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@Column(name = "AUTEUR", nullable = false, length = 50)
	private String auteur;
	@Column(name = "TITRE", nullable = false, length = 50)
	private String titre;
	@Column(name = "NB_PAGES", nullable = false, length = 5)
	private int nbPages;
	
	public Livre() {
	}
	
	public Livre(String auteur, String titre, int nbPages) {
		setAuteur(auteur);
		setTitre(titre);
		setNbPages(nbPages);
	}
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getNbPages() {
		return nbPages;
	}

	public void setNbPages(int nbPages) {
		this.nbPages = nbPages;
	}

	@Override
	public String toString() {
		return "Livre [id="+id+", titre=" + titre +", auteur="+auteur+", nbPages="+nbPages+"]";
	}
	
	
}
