package fr.eni.jpa.methode1.main;

import java.util.GregorianCalendar;
import java.util.List;



import fr.eni.jpa.methode1.entity.Personne;
import fr.eni.jpa.methode1.entity.PersonnePK;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class TestPersonne {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Mysql_UP");
		EntityManager em = emf.createEntityManager();
		
		Personne p1 = new Personne("Dupont", "Alfred", new GregorianCalendar(1986, 06, 30)); // 30/07/1986
		Personne p2 = new Personne("Legrand", "Lucie", new GregorianCalendar(2000, 05, 22)); // 22/06/2000
		System.out.println(p1);
		
		em.getTransaction().begin();
		try {
			System.out.println("Transaction commenc�!");
			em.persist(p1);
			em.persist(p2);
			em.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		String requete = "FROM Personne1 p";
		List<Personne> listeP = em.createQuery(requete).getResultList();
		
		System.out.println("Liste des Personnes : ");
		for(Personne personne: listeP) {
			System.out.println(personne);
		}
		
		PersonnePK pk = new PersonnePK();
		pk.setNom("Legrand");
		pk.setPrenom("Lucie");
		Personne p = em.find(Personne.class, pk);
		System.out.println(p);
		
	em.close();
	emf.close();
	}
}
