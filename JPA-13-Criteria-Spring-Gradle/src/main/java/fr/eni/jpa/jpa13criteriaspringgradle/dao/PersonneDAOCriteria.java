package fr.eni.jpa.jpa13criteriaspringgradle.dao;

import fr.eni.jpa.jpa13criteriaspringgradle.entity.Civilite;
import fr.eni.jpa.jpa13criteriaspringgradle.entity.Personne;
import fr.eni.jpa.jpa13criteriaspringgradle.exception.DAOException;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;
public class PersonneDAOCriteria {

	public static void add(Personne personne) throws DAOException {
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
		EntityManager em = DAOUtil.getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Personne> query = cb.createQuery(Personne.class);
		Root<Personne> liste = query.from(Personne.class);
		query.select(liste);
		TypedQuery<Personne> tq = em.createQuery(query);
		return tq.getResultList();
	}
	
	// orderBy
	public  static List<Personne> findAllTriParNom() {
		EntityManager em = DAOUtil.getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Personne> query = cb.createQuery(Personne.class);
		Root<Personne> pers = query.from(Personne.class);
		Order ordre = cb.asc(pers.get("nom"));
		query.select(pers);
		query.orderBy(ordre);
		TypedQuery<Personne> tq = em.createQuery(query);
		return tq.getResultList();
	}
	
	// where
	public  static List<Personne> findLegrand() {
		EntityManager em = DAOUtil.getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Personne> query = cb.createQuery(Personne.class);
		Root<Personne> pers = query.from(Personne.class);
		Predicate clauseWhere = cb.equal(pers.get("nom"), "Legrand");
		query.select(pers);
		query.where(clauseWhere);
		TypedQuery<Personne> tq = em.createQuery(query);
		return tq.getResultList();
	}
	
	// join + where
		public  static List<Personne> findMesdemoiselles() {
			EntityManager em = DAOUtil.getEntityManager();
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Personne> query = cb.createQuery(Personne.class);
			Root<Personne> pers = query.from(Personne.class);
			Join<Personne, Civilite> civ = pers.join("civilite");
			Predicate clauseWhere = cb.equal(civ.get("cle"), "Mlle");
			query.select(pers);
			query.where(clauseWhere);
			TypedQuery<Personne> tq = em.createQuery(query);
			return tq.getResultList();
		}
}
