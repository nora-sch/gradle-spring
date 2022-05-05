package JPA.OneToOne.dao;

import java.util.List;

import JPA.OneToOne.entity.Personne;
import jakarta.persistence.EntityManager;

public class PersonneDAO {

	public void add(Personne presonne){
		EntityManager em = DAOUtil.getEntityManager();
			em.getTransaction().begin();
		try {
			em.persist(presonne);
			em.getTransaction().commit();		
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}
	
	public void update(Personne presonne){
		EntityManager em = DAOUtil.getEntityManager();
		em.getTransaction().begin();
		try {
			em.merge(presonne);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}
	
	public void delete(Personne presonne){
		EntityManager em = DAOUtil.getEntityManager();
		em.getTransaction().begin();
		presonne = em.find(Personne.class, presonne.getId());
		try {
			em.remove(presonne);
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
