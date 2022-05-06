package JPA.ManyToMany.dao;

import java.util.List;

import JPA.ManyToMany.entity.Pays;
import JPA.ManyToMany.exception.DAOException;
import jakarta.persistence.EntityManager;

public class PaysDAO{
	
	public static void add(Pays pays)throws DAOException{
		EntityManager em = DAOUtil.getEntityManager();
			em.getTransaction().begin();
		try {
			em.persist(pays);
			em.getTransaction().commit();		
		}catch(Exception e) {
			em.getTransaction().rollback();
			throw new DAOException("Erreur lors de l'ajout de la pays "+pays+" : "+e.getMessage());
		}
	}
		
	public static void update(Pays pays) throws DAOException{
		EntityManager em = DAOUtil.getEntityManager();
		em.getTransaction().begin();
		try {
			em.merge(pays);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new DAOException("Erreur lors de la modification de la pays "+pays+" : "+e.getMessage());
		}
	}
	
	public static void delete(Pays pays) throws DAOException{
		EntityManager em = DAOUtil.getEntityManager();
		em.getTransaction().begin();
		try {
			em.remove(pays);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new DAOException("Erreur lors de la suppression de la pays "+pays+" : "+e.getMessage());
			}
	}
	
	public static List<Pays> findAll() {
		String req = "Select Object(p) from Pays p";
		return DAOUtil.getEntityManager().createQuery(req, Pays.class).getResultList();
	}

	public static Pays findById(String id) {
		return DAOUtil.getEntityManager().find(Pays.class, id);
	}
}
