package JPA.PremierExemple;

import java.util.List;

import JPA.PremierExemple.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestUser {

	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Mysql_UP");
		EntityManager em = emf.createEntityManager();
		
		User u1 = new User("java", "avance");
		
		em.getTransaction().begin();
		try {
			System.out.println("Transaction commencé!");
			em.persist(u1);
			em.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		String requete = "FROM User u";
		List<User> listeU = em.createQuery(requete).getResultList();
		
		System.out.println("Liste des User : ");
		for(User user: listeU) {
			System.out.println(user.toString());
		}
	em.close();
	emf.close();
	}

}
