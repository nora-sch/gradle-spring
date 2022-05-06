package JPA.OneToMany.Bi.dao;

import java.util.List;

import JPA.OneToMany.Bi.entity.Adresse;
import JPA.OneToMany.Bi.exception.DAOException;
import jakarta.persistence.EntityManager;

public class AdresseDAO{
	
	public void add(Adresse adresse)throws DAOException{
		EntityManager em = DAOUtil.getEntityManager();
			em.getTransaction().begin();
		try {
			em.persist(adresse);
			em.getTransaction().commit();		
		}catch(Exception e) {
			em.getTransaction().rollback();
			throw new DAOException("Erreur lors de l'ajout de l'adresse "+adresse+" : "+e.getMessage());
		}
	}
	
	public void update(Adresse adresse) throws DAOException{
		EntityManager em = DAOUtil.getEntityManager();
		em.getTransaction().begin();
		try {
			em.merge(adresse);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new DAOException("Erreur lors de la modification de l'adresse "+adresse+" : "+e.getMessage());
		}
	}
	
	public void delete(Adresse adresse) throws DAOException{
		EntityManager em = DAOUtil.getEntityManager();
		em.getTransaction().begin();
		try {
			em.remove(adresse);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new DAOException("Erreur lors de la suppression de l'adresse "+adresse+" : "+e.getMessage());
			}
	}
	
	public List<Adresse> findAll() {
		String req = "Select Object(a) from Adresse a";
		return DAOUtil.getEntityManager().createQuery(req, Adresse.class).getResultList();
	}
}
