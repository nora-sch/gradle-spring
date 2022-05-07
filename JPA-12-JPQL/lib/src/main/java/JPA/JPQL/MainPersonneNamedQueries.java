package JPA.JPQL;

import java.util.List;

import JPA.JPQL.dao.CiviliteDAO;
import JPA.JPQL.dao.DAOUtil;
import JPA.JPQL.dao.PersonneDAO;
import JPA.JPQL.entity.Civilite;
import JPA.JPQL.entity.Personne;

public class MainPersonneNamedQueries {

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
		Personne p3 = new Personne("N30", "P3", mme);
		Personne p4 = new Personne("N14", "P4", mme);
		Personne p5 = new Personne("N50", "P5", mlle);
		Personne p6 = new Personne("N16", "P6", m);
		Personne p7 = new Personne("N17", "P7", mme);
				
		try {
			PersonneDAO.add(p1);
			PersonneDAO.add(p2);
			PersonneDAO.add(p3);
			PersonneDAO.add(p4);
			PersonneDAO.add(p5);
			PersonneDAO.add(p6);
			PersonneDAO.add(p7);
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
		System.out.println("\nTous : ");
		List<Personne> listeP = PersonneDAO.findTous();
		for(Personne p : listeP) {
			System.out.println(p);
		}
		System.out.println("\nTous les N1 : ");
		listeP = PersonneDAO.findNomCommencePar("N1");
		for(Personne p : listeP) {
			System.out.println(p);
		}
		System.out.println("\nTous les Messieurs : ");
		listeP = PersonneDAO.findMessieurs();
		for(Personne p : listeP) {
			System.out.println(p);
		}
		
		Personne res = PersonneDAO.findByIdQuery(1);
		System.out.println(res);
		
		DAOUtil.close();
	}

}
