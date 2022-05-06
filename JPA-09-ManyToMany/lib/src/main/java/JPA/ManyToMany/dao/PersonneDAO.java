package JPA.ManyToMany.dao;

import java.util.List;

import JPA.ManyToMany.entity.Personne;
import JPA.ManyToMany.exception.DAOException;
import jakarta.persistence.EntityManager;

public class PersonneDAO {

	public static void add(Personne personne) throws DAOException{
		EntityManager em = DAOUtil.getEntityManager();
			em.getTransaction().begin();
		try {
			em.persist(personne);
			em.getTransaction().commit();		
		}catch(Exception e) {
			em.getTransaction().rollback();
			throw new DAOException("Erreur lors de l'ajout de la personne "+personne+" : "+e.getMessage());
		}
	}
	
	public static void update(Personne personne) throws DAOException{
		EntityManager em = DAOUtil.getEntityManager();
		em.getTransaction().begin();
		try {
			em.merge(personne);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new DAOException("Erreur lors de la modification de la personne "+personne+" : "+e.getMessage());
		}
	}
	
	public static void delete(Personne personne) throws DAOException{
		EntityManager em = DAOUtil.getEntityManager();
		em.getTransaction().begin();
		try {
			em.remove(personne);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new DAOException("Erreur lors de la suppression de la personne "+personne+" : "+e.getMessage());
			}
	}
	
	public static void deleteAll() throws DAOException{
		String req = "DELETE FROM Personne p";
		EntityManager em = DAOUtil.getEntityManager();
		em.getTransaction().begin();
		try {
			em.createQuery(req).executeUpdate();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new DAOException("Erreur lors de la suppression de toutes les personnes : "+e.getMessage());
			}
	}
	
	
	public  static List<Personne> findAll() {
		String req = "Select Object(p) from Personne p";
		return DAOUtil.getEntityManager().createQuery(req, Personne.class).getResultList();
	}
}
