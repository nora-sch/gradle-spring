package JPA.ManyToOne;

import java.util.List;

import JPA.ManyToOne.dao.CiviliteDAO;
import JPA.ManyToOne.dao.PersonneDAO;
import JPA.ManyToOne.entity.Civilite;
import JPA.ManyToOne.entity.Personne;

public class MainPersonne {
	
	public static void main(String[] args) {
		
		// civilité
		
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

			// personne
		
		try {
			PersonneDAO.deleteAll();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
		Civilite mlle = CiviliteDAO.findById("Mlle");
		Civilite mme = CiviliteDAO.findById("Mme");
		Civilite m = CiviliteDAO.findById("M");
		
		System.out.println(mlle);
		System.out.println(mme);
		System.out.println(m);
		
		Personne p1 = new Personne("N1", "P1", m);
		Personne p2 = new Personne("N2", "P2", mlle);
		Personne p3 = new Personne("N3", "P3", mme);
		Personne p4 = new Personne("N4", "P4", mme);
		Personne p5 = new Personne("N5", "P5", mlle);
		Personne p6 = new Personne("N6", "P6", m);
		Personne p7 = new Personne("N7", "P7", mme);
		
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
		
		System.out.println("\nListe des personnes en base : ");
		List<Personne> listeP = PersonneDAO.findAll();
		for(Personne p : listeP) {
			System.out.println(p);
		}
		
		try {
			PersonneDAO.delete(p2);
			PersonneDAO.delete(p5);
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
		System.out.println("\nListe des personnes en base apres suppr : ");
		listeP = PersonneDAO.findAll();
		for(Personne p : listeP) {
			System.out.println(p);
		}
		
		System.out.println("\nListe des civilites en base apres suppr : ");
		List<Civilite> listeC = CiviliteDAO.findAll();
		for(Civilite c : listeC) {
			System.out.println(c);
		}
	}

}
