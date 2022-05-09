package fr.eni.jpa.jpa13criteriaspring.dao;

import java.util.List;

import JPA.Criteria.entity.Civilite;
import JPA.Criteria.exception.DAOException;
import jakarta.persistence.EntityManager;

public class CiviliteDAO{
	
	public static void add(Civilite civilite)throws DAOException{
		EntityManager em = DAOUtil.getEntityManager();
			em.getTransaction().begin();
		try {
			em.persist(civilite);
			em.getTransaction().commit();		
		}catch(Exception e) {
			em.getTransaction().rollback();
			throw new DAOException("Erreur lors de l'ajout de la civilit� "+civilite+" : "+e.getMessage());
		}
	}
		
	public static List<Civilite> findAll() {
		String req = "Select Object(c) from Civilite c";
		return DAOUtil.getEntityManager().createQuery(req, Civilite.class).getResultList();
	}

	public static Civilite findById(String id) {
		return DAOUtil.getEntityManager().find(Civilite.class, id);
	}
}
