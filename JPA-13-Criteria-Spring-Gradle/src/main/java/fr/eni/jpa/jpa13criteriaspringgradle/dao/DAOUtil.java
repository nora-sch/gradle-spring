package fr.eni.jpa.jpa13criteriaspringgradle.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class DAOUtil {
		
	//private static EntityManagerFactory emf;
	@PersistenceContext
	private static EntityManager em;
		
		static{
			//emf = Persistence.createEntityManagerFactory("Mysql_UP");
			//em = emf.createEntityManager();
		}
		
		public static EntityManager getEntityManager() {
			return em;
		}
		
		public static void close() {
			if(em != null)
			em.close();
			//if(emf != null)
			//emf.close();
		}
}


