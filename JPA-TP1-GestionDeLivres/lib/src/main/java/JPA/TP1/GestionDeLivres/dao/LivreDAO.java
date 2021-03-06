package JPA.TP1.GestionDeLivres.dao;

import java.time.LocalDate;
import java.util.List;

import JPA.TP1.GestionDeLivres.DAOException;
import JPA.TP1.GestionDeLivres.entity.Livre;
import jakarta.persistence.EntityManager;


public class LivreDAO {
	
	public static void insert(Livre livre) throws DAOException{
		
		if(livre==null) {
			DAOException daoException = new DAOException("Pas des infos sur la livre fournies!");
			throw daoException;
		}
		
		EntityManager em = DAOUtil.getEntityManager();
			em.getTransaction().begin();
		try {
			em.persist(livre);
			em.getTransaction().commit();		
		}catch(Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new DAOException("Erreur  - la livre " + livre + " n'a pas pu ?tre ajout?! "+e.getMessage());
		}
		//close();
	}

	public void delete(Livre livre) throws DAOException {
		EntityManager em = DAOUtil.getEntityManager();
		em.getTransaction().begin();
		livre = em.find(Livre.class, livre.getId());
		try {
			em.remove(livre);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new DAOException("Erreur  - la livre " + livre + " n'a pas pu ?tre supprim?e! "+e.getMessage());
		}
	}
	
	public void deleteById(int id) throws DAOException {
		EntityManager em = DAOUtil.getEntityManager();
		em.getTransaction().begin();
		Livre livre = em.find(Livre.class, id);
		try {
			em.remove(livre);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new DAOException("Erreur  - la livre " + livre + " n'a pas pu ?tre supprim?e! "+e.getMessage());
		}
	}
	
	public void update(Livre livre) throws DAOException {
		EntityManager em = DAOUtil.getEntityManager();
		em.getTransaction().begin();
		try {
			em.merge(livre);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new DAOException("Erreur  - la livre " + livre + " n'a pas pu ?tre modifi?e! "+e.getMessage());
		}
	}
	
	public Livre findById(int val) {
		return DAOUtil.getEntityManager().find(Livre.class, val);
	}

	public List<Livre> findAll() {
		String req = "Select Object(l) from Livre l";
		return DAOUtil.getEntityManager().createQuery(req, Livre.class).getResultList();
	}

	public List<Livre> findAllOrderByTitreAsc() {
		String req = "Select Object(l) from Livre l Order By l.titre ASC";
		return DAOUtil.getEntityManager().createQuery(req, Livre.class).getResultList();
	}

	public List<Livre> findAllOrderByTitreDesc() {
		String req = "Select Object(l) from Livre l Order By l.titre DESC";
		return DAOUtil.getEntityManager().createQuery(req, Livre.class).getResultList();
	}

	public List<Livre> findByAuteurLike(String auteur) {
		String req = "Select Object(l) from Livre l WHERE l.auteur LIKE :aut";
		return DAOUtil.getEntityManager().createQuery(req, Livre.class).setParameter("aut", "%" + auteur + "%")
				.getResultList();
	}

	public int getMaxId() {
		String req = "Select max(l.id) from Livre l";
		return DAOUtil.getEntityManager().createQuery(req, Integer.class).getSingleResult();
	}

	public int getMinId() {
		String req = "Select min(l.id) from Livre l";
		return DAOUtil.getEntityManager().createQuery(req, Integer.class).getSingleResult();
	}
	
}
