package JPA.OneToOne;

import java.util.GregorianCalendar;
import java.util.List;

import JPA.OneToOne.dao.DAOUtil;
import JPA.OneToOne.dao.PersonneDAO;
import JPA.OneToOne.entity.Adresse;
import JPA.OneToOne.entity.Personne;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class TestPersonne {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		
		Adresse a1 = new Adresse("44000", "Nantes");
		Personne p1 = new Personne("Lebrun", "Jeanne", a1); 
		Adresse a2 = new Adresse("33000", "Bordeaux");
		Personne p2 = new Personne("Leblond", "Annie", a2); 
		System.out.println(p1);
		System.out.println(p2);
		
		PersonneDAO dao = new PersonneDAO();
		try {
			dao.add(p1);
			dao.add(p2);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		p1.getAdresse().setCodePostal("44100");
		try {
			dao.update(p1);
		}catch(Exception e) {
			e.printStackTrace();
		}
				
		List<Personne> listeP  = dao.findAll();
		
		System.out.println("Liste des Personnes (nom) : ");
		for(Personne personne: listeP) {
			System.out.println(personne.getNom());
		}
		System.out.println("Liste des Personnes (adresse) : ");
		for(Personne personne: listeP) {
			System.out.println(personne.getAdresse());
		}
		
		System.out.println("Supression de p1 : ");
		try {
			dao.delete(p1);
			System.out.println("["+p1+"]" + " a été suprimé!");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		DAOUtil.close();
	}
}
