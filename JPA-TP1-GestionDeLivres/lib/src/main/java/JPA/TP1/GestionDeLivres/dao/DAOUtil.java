package JPA.TP1.GestionDeLivres.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DAOUtil {
	
	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	static{
		emf = Persistence.createEntityManagerFactory("Mysql_UP");
		em = emf.createEntityManager();
	}
	
	public static EntityManager getEntityManager() {
		return em;
	}
	
	public static void close() {
		em.close();
		emf.close();
	}
}
