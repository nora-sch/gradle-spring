package JPA.Annotations;

import java.util.GregorianCalendar;
import java.util.List;

import JPA.Annotations.entity.Personne;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestPersonne {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Mysql_UP");
		EntityManager em = emf.createEntityManager();
		
		Personne p1 = new Personne("Dupont", "Alfred", new GregorianCalendar(1986, 06, 30)); // 22/06/2000
		System.out.println(p1);
		
		em.getTransaction().begin();
		try {
			System.out.println("Transaction commencé!");
			em.persist(p1);
			em.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		String requete = "FROM Personne p";
		List<Personne> listeP = em.createQuery(requete).getResultList();
		
		System.out.println("Liste des Personnes : ");
		for(Personne personne: listeP) {
			System.out.println(personne);
		}
	em.close();
	emf.close();
	}
}
