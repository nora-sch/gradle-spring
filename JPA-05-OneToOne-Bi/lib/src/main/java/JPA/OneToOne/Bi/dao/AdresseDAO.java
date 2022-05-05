package JPA.OneToOne.Bi.dao;

import java.util.List;

import JPA.OneToOne.Bi.entity.Adresse;
import jakarta.persistence.EntityManager;

public class AdresseDAO {
	
	public void add(Adresse adresse){
		EntityManager em = DAOUtil.getEntityManager();
			em.getTransaction().begin();
		try {
			em.persist(adresse);
			em.getTransaction().commit();		
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}
	
	public void update(Adresse adresse){
		EntityManager em = DAOUtil.getEntityManager();
		em.getTransaction().begin();
		try {
			em.merge(adresse);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}
	
	public void delete(Adresse adresse){
		EntityManager em = DAOUtil.getEntityManager();
		em.getTransaction().begin();
		try {
			em.remove(adresse);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			}
	}
	
	public List<Adresse> findAll() {
		String req = "Select Object(a) from Adresse a";
		return DAOUtil.getEntityManager().createQuery(req, Adresse.class).getResultList();
	}
}
