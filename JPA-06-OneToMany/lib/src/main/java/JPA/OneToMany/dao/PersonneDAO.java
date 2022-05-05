package JPA.OneToMany.dao;

import java.util.List;

import JPA.OneToMany.entity.Personne;
import JPA.OneToMany.exception.DAOException;
import jakarta.persistence.EntityManager;

public class PersonneDAO {

	public void add(Personne personne) throws DAOException{
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
	
	public void update(Personne personne) throws DAOException{
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
	
	public void delete(Personne personne) throws DAOException{
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
	
	public List<Personne> findAll() {
		String req = "Select Object(p) from Personne p";
		return DAOUtil.getEntityManager().createQuery(req, Personne.class).getResultList();
	}
}
