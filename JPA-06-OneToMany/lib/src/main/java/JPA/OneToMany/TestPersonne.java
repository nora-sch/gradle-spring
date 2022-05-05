package JPA.OneToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.internal.build.AllowSysOut;

import JPA.OneToMany.dao.AdresseDAO;
import JPA.OneToMany.dao.DAOUtil;
import JPA.OneToMany.dao.PersonneDAO;
import JPA.OneToMany.entity.Adresse;
import JPA.OneToMany.entity.Personne;



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
		
		// modification
		a1.setCodePostal("44100"); // identique à p1.getListeAdresses().get(0).setCodePostal("44100");
		
		Adresse a5 = new Adresse("75000", "Rennes");
		p1.getListeAdresses().add(a5);
		
		try {
			pDao.update(p1);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("\nListe des personnes en base après modif de p1 : ");
		listeP = pDao.findAll();
		for(Personne p : listeP) {
			System.out.println(p);
		}
		
		// supression
		p1.getListeAdresses().remove(a2);
		try {
			pDao.update(p1);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("\nListe des personnes en base après supp de a2 : ");
		listeP = pDao.findAll();
		for(Personne p : listeP) {
			System.out.println(p);
		}
		
		// remplacement de la liste
		Adresse a6 = new Adresse("59000", "Lille");
		Adresse a7 = new Adresse("69000", "Lyon");
		
	    List<Adresse> liste3 = new ArrayList<Adresse>();
	    liste3.add(a6);
	    liste3.add(a7);
	    
	    p2.setListeAdresses(liste3);
	    try {
			pDao.update(p2);
		}catch(Exception e) {
			e.printStackTrace();
		}
	    System.out.println("\nListe des personnes en base après remplacement de la liste de p2 : ");
		listeP = pDao.findAll();
		for(Personne p : listeP) {
			System.out.println(p);
		}
		
		// supression des 2 personnes
		 try {
			 	pDao.delete(p1);
				pDao.delete(p2);
			}catch(Exception e) {
				e.printStackTrace();
			}
		 System.out.println("\nListe des personnes en base après supression des personnes : ");
			listeP = pDao.findAll();
			for(Personne p : listeP) {
				System.out.println(p);
			}
		
		DAOUtil.close();
	}
}
