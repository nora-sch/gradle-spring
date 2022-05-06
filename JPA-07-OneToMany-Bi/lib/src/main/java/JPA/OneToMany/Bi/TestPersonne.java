package JPA.OneToMany.Bi;

import java.util.ArrayList;
import java.util.List;

import JPA.OneToMany.Bi.dao.AdresseDAO;
import JPA.OneToMany.Bi.dao.DAOUtil;
import JPA.OneToMany.Bi.dao.PersonneDAO;
import JPA.OneToMany.Bi.entity.Adresse;
import JPA.OneToMany.Bi.entity.Personne;



public class TestPersonne {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		
		Adresse a1 = new Adresse("44000", "Nantes");
	    Adresse a2 = new Adresse("56000", "Vannes");
	    Adresse a3 = new Adresse("29200", "Brest");
	    Adresse a4 = new Adresse("29000", "Quimper");

	    List<Adresse> liste1 = new ArrayList<Adresse>();
	    List<Adresse> liste2 = new ArrayList<Adresse>();
	    
	    liste1.add(a1);
	    liste1.add(a2);
	    liste2.add(a3);
	    liste2.add(a4);
	    
		Personne p1 = new Personne("Lebrun", "Jeanne", liste1); 
		Personne p2 = new Personne("Leblond", "Annie", liste2); 
		
		PersonneDAO pDao = new PersonneDAO();
		AdresseDAO aDao = new AdresseDAO();
		
		try {
			pDao.add(p1);
			pDao.add(p2);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("\n Liste des personnes en base : ");
		List<Personne> listeP = pDao.findAll();
		for(Personne p : listeP) {
			System.out.println(p);
		}
		
	    Adresse a24 = new Adresse("31000", "Toulouse");
	    List<Adresse> listeA = new ArrayList<>();
	    
	    listeA.add(a24);
	    
	    Personne p24 = new Personne("Lechauve", "Marie", listeA);
	    
	    // tentative de sauvegarde de l'adresse
	    try {
			aDao.add(a24);
		}catch(Exception e) {
			e.printStackTrace();
		}
	    System.out.println("\nListe des personnes en base après ajout adresse: ");
	    listeP = pDao.findAll();
		for(Personne p : listeP) {
			System.out.println(p);
		}
		
		// supression de p1
		  try {
				pDao.delete(p1);
			}catch(Exception e) {
				e.printStackTrace();
			}
		  listeP = pDao.findAll();
			for(Personne p : listeP) {
				System.out.println(p);
			}
					
		DAOUtil.close();
	}
}
