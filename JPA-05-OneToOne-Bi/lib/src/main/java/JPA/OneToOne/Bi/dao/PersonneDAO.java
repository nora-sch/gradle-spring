package JPA.OneToOne.Bi.dao;

import java.util.List;

import JPA.OneToOne.Bi.entity.Personne;
import jakarta.persistence.EntityManager;

public class PersonneDAO {

	public void add(Personne personne){
		EntityManager em = DAOUtil.getEntityManager();
			em.getTransaction().begin();
		try {
			em.persist(personne);
			em.getTransaction().commit();		
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}
	
	public void update(Personne personne){
		EntityManager em = DAOUtil.getEntityManager();
		em.getTransaction().begin();
		try {
			em.merge(personne);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}
	
	public void delete(Personne personne){
		EntityManager em = DAOUtil.getEntityManager();
		em.getTransaction().begin();
		try {
			em.remove(personne);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			}
	}
	
	public List<Personne> findAll() {
		String req = "Select Object(p) from Personne p";
		return DAOUtil.getEntityManager().createQuery(req, Personne.class).getResultList();
	}
}
