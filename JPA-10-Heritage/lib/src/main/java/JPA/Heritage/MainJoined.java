package JPA.Heritage;

import java.util.List;

import JPA.Heritage.dao.DAOUtil;
import JPA.Heritage.entity.joined.Berline;
import JPA.Heritage.entity.joined.Voiture;
import JPA.Heritage.entity.joined.VoitureDeCourse;
import jakarta.persistence.EntityManager;

public class MainJoined {

	public static void main(String[] args) {
		
		Voiture v1  = new Voiture("Renault Clio");
		Berline b1  = new Berline("BMW", "rouge");
		VoitureDeCourse c1 = new VoitureDeCourse("Ferrari", "Scuderia Ferrari");
		
		EntityManager em = DAOUtil.getEntityManager();
		em.getTransaction().begin();
	try {
		em.persist(v1);
		em.persist(b1);
		em.persist(c1);
		em.getTransaction().commit();		
	}catch(Exception e) {
		e.printStackTrace();
		em.getTransaction().rollback();
	}
		
		List<Voiture> liste = null;
		
		System.out.println("\nListe des voitures de courses : ");
		liste = em.createQuery("Select Object(v) from JoinedVoitureDeCourseEntity v", Voiture.class).getResultList();
		for(Voiture voiture : liste) {
			System.out.println(voiture);
		}
		
		System.out.println("\nListe des berlines : ");
		liste = em.createQuery("Select Object(v) from JoinedBerlineEntity v", Voiture.class).getResultList();
		for(Voiture voiture : liste) {
			System.out.println(voiture);
		}
		
		System.out.println("\nListe des voitures (toutes) : ");
		liste = em.createQuery("Select Object(v) from JoinedVoitureEntity v", Voiture.class).getResultList();
		for(Voiture voiture : liste) {
			System.out.println(voiture);
		}
				
		DAOUtil.close();

	}

}
