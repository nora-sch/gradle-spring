package JPA.ManyToMany;

import java.util.List;

import JPA.ManyToMany.dao.DAOUtil;
import JPA.ManyToMany.dao.PaysDAO;
import JPA.ManyToMany.dao.PersonneDAO;
import JPA.ManyToMany.entity.Pays;
import JPA.ManyToMany.entity.Personne;

public class Main {
	
	
	private static Pays getPays(String cle, String libelle) {
		Pays p = PaysDAO.findById(cle);
		if(p == null) {
			p = new Pays(cle, libelle);
			try {
				PaysDAO.add(p);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return p;
	}

	public static void main(String[] args) {
		
		Pays fr = getPays("fr", "France");
		Pays it = getPays("it", "Italie");
		Pays gb = getPays("gb", "Grande Bretagne");
		Pays gr = getPays("gr", "Grece");
		Pays es = getPays("es", "Espagne");
		
		Personne p1 = new Personne("Leblond", "Jean");
		Personne p2 = new Personne("Lechatain", "Lucie");
		
		p1.addPaysVisite(fr);
		p1.addPaysVisite(it);
		p1.addPaysVisite(es);
		
		p2.addPaysVisite(fr);
		p2.addPaysVisite(gb);
		p2.addPaysVisite(gr);
		
		try {
			PersonneDAO.add(p1);
			PersonneDAO.add(p2);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("\nListe des personnes en base");
		List<Personne> listeP = PersonneDAO.findAll();
		for(Personne p : listeP) {
			System.out.println(p);
		}

		
		// remove
		
		p2.removePaysVisite(gb);
		Pays po = getPays("po", "Portugal");
		p2.addPaysVisite(po);
		
		try {
			PersonneDAO.update(p2);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("\nListe des personnes en base après ajout de Portugale");
		listeP = PersonneDAO.findAll();
		for(Personne p : listeP) {
			System.out.println(p);
		}
		
		System.out.println("\nListe des Pays : ");
		List<Pays> listePays = PaysDAO.findAll();
		for(Pays pays : listePays) {
			System.out.println(pays);
		}
		DAOUtil.close();
	}
	


}
