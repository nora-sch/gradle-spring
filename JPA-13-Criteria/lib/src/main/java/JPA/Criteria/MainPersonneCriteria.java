package JPA.Criteria;

import java.util.List;

import JPA.Criteria.dao.CiviliteDAO;
import JPA.Criteria.dao.DAOUtil;
import JPA.Criteria.dao.PersonneDAOCriteria;
import JPA.Criteria.entity.Civilite;
import JPA.Criteria.entity.Personne;


public class MainPersonneCriteria {

	public static void main(String[] args) {

		Civilite c1 = new Civilite("M", "Monsieur");
		Civilite c2 = new Civilite("Mlle", "Mademoiselle");
		Civilite c3 = new Civilite("Mme", "Madame");

		try {
			CiviliteDAO.add(c1);
			CiviliteDAO.add(c2);
			CiviliteDAO.add(c3);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Civilite mlle = CiviliteDAO.findById("Mlle");
		Civilite mme = CiviliteDAO.findById("Mme");
		Civilite m = CiviliteDAO.findById("M");
				
		Personne p1 = new Personne("N10", "P1", m);
		Personne p2 = new Personne("N20", "P2", mlle);
		Personne p3 = new Personne("Legrand", "P3", mme);
		Personne p4 = new Personne("N14", "P4", mme);
		Personne p5 = new Personne("N50", "P5", mlle);
		Personne p6 = new Personne("N16", "P6", m);
		Personne p7 = new Personne("N17", "P7", mme);
		Personne p8 = new Personne("Legrand", "Aline", mme);
		Personne p9 = new Personne("Lepetit", "Lucie", mlle);
				
		try {
			PersonneDAOCriteria.add(p1);
			PersonneDAOCriteria.add(p2);
			PersonneDAOCriteria.add(p3);
			PersonneDAOCriteria.add(p4);
			PersonneDAOCriteria.add(p5);
			PersonneDAOCriteria.add(p6);
			PersonneDAOCriteria.add(p7);
			PersonneDAOCriteria.add(p8);
			PersonneDAOCriteria.add(p9);
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
		System.out.println("\nTous : ");
		List<Personne> listeP = PersonneDAOCriteria.findAll();
		for(Personne p : listeP) {
			System.out.println(p);
		}
		System.out.println("\nTous triés par nom : ");
		listeP = PersonneDAOCriteria.findAllTriParNom();
		for(Personne p : listeP) {
			System.out.println(p);
		}
		System.out.println("\nTous les Legrand : ");
		listeP = PersonneDAOCriteria.findLegrand();
		for(Personne p : listeP) {
			System.out.println(p);
		}
		System.out.println("\nTous les Mademoiselles : ");
		listeP = PersonneDAOCriteria.findMesdemoiselles();
		for(Personne p : listeP) {
			System.out.println(p);
		}
		
		DAOUtil.close();
	}

}
