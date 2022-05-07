package JPA.JPQL.dao;

import java.util.List;



import JPA.JPQL.entity.Personne;
import JPA.JPQL.exception.DAOException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

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
	
	public  static List<Personne> findLegrand() {
		EntityManager em = DAOUtil.getEntityManager();
		Query query = em.createQuery("SELECT p FROM Personne p WHERE p.nom = 'Legrand'");
		return query.getResultList();
	}
	
	public  static List<Personne> findLepetit() {
		EntityManager em = DAOUtil.getEntityManager();
		TypedQuery<Personne> query = em.createQuery("SELECT p FROM Personne p WHERE p.nom = 'Lepetit'", Personne.class);
		return query.getResultList();
	}
	
	
	public  static List<Personne> findTous() {
		TypedQuery<Personne> query = DAOUtil.getEntityManager().createNamedQuery("findTous", Personne.class);
		return query.getResultList();
	}
	public  static List<Personne> findNomCommencePar(String debut) {
		TypedQuery<Personne> query = DAOUtil.getEntityManager().createNamedQuery("findNomCommencePar", Personne.class);
		return query.setParameter("var", debut+"%").getResultList();
	}
	public  static List<Personne> findMessieurs() {
		TypedQuery<Personne> query = DAOUtil.getEntityManager().createNamedQuery("findMessieurs", Personne.class);
		return query.getResultList();
	}
	
	
	public  static List<Personne> findByNom(String nom) {
		EntityManager em = DAOUtil.getEntityManager();
		TypedQuery<Personne> query = em.createQuery("SELECT p FROM Personne p WHERE p.nom = :nom", Personne.class);
		query.setParameter("nom", nom);
		return query.getResultList();
	}
	
	public  static List<Personne> findByNom2(String nom) {
		EntityManager em = DAOUtil.getEntityManager();
		TypedQuery<Personne> query = em.createQuery("SELECT p FROM Personne p WHERE p.nom = ?1 ", Personne.class);
		query.setParameter(1, nom);
		return query.getResultList();
	}
	
	public static Personne findById(int id) {
		return DAOUtil.getEntityManager().find(Personne.class, id);
	}
	
	public static Personne findByIdQuery(int id) {
		EntityManager em = DAOUtil.getEntityManager();
		TypedQuery<Personne> query = em.createQuery("SELECT p FROM Personne p WHERE p.id = :id", Personne.class);
		query.setParameter("id", id);
		Personne pers = null;
		
		try {
			pers=query.getSingleResult();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return pers;
	}
	
	public static long nombreDElements() {
		EntityManager em = DAOUtil.getEntityManager();
		TypedQuery<Long> query = em.createQuery("SELECT COUNT(p.id) FROM Personne p", Long.class);
		return query.getSingleResult();
	}
	
	public static List<String> tousLesPrenom() {
		EntityManager em = DAOUtil.getEntityManager();
		TypedQuery<String> query = em.createQuery("SELECT p.prenom FROM Personne p", String.class);
		return query.getResultList();
	}
	
	public static List<Personne> jointure() {
		EntityManager em = DAOUtil.getEntityManager();
		TypedQuery<Personne> query = em.createQuery("SELECT p FROM Personne p JOIN p.civilite c WHERE c.cle='Mlle'", Personne.class);
		return query.getResultList();
	}
	
	public static List<Personne> jointureAvecTri() {
		EntityManager em = DAOUtil.getEntityManager();
		TypedQuery<Personne> query = em.createQuery("SELECT p FROM Personne p JOIN p.civilite c ORDER BY c.libelle", Personne.class);
		return query.getResultList();
	}
	
	public static void supressionLegrand() throws DAOException{
		EntityManager em = DAOUtil.getEntityManager();
		Query query = em.createQuery("DELETE FROM Personne p WHERE p.nom='Legrand'");
		em.getTransaction().begin();
		try {
			query.executeUpdate();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new DAOException("Erreur lors de la suppression des personnes avec nom Legrand : "+e.getMessage());
			}
	}
	
	
}
