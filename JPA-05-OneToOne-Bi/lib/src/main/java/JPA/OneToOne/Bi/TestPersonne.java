package JPA.OneToOne.Bi;

import java.util.List;

import JPA.OneToOne.Bi.dao.AdresseDAO;
import JPA.OneToOne.Bi.dao.DAOUtil;
import JPA.OneToOne.Bi.dao.PersonneDAO;
import JPA.OneToOne.Bi.entity.Adresse;
import JPA.OneToOne.Bi.entity.Personne;



public class TestPersonne {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		
		Adresse a1 = new Adresse("44000", "Nantes");
		Personne p1 = new Personne("Lebrun", "Jeanne", a1); 
		Adresse a2 = new Adresse("33000", "Bordeaux");
		Personne p2 = new Personne("Leblond", "Annie", a2); 
		System.out.println(p1);
		//System.out.println(p2);
		
		PersonneDAO pDao = new PersonneDAO();
		AdresseDAO aDao = new AdresseDAO();
		try {
			pDao.add(p1);
			pDao.add(p2);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			aDao.delete(a1);
			System.out.println("Adresse : ["+a1+"]" + " a été suprimé!");
			System.out.println("DELETE ADRESSE ET LA PERSONNE QUI A CETTE ADRESSE");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("echec supression");
		}
				
		List<Personne> listeP  = pDao.findAll();
		System.out.println("Liste des Personnes : ");
		for(Personne personne: listeP) {
			System.out.println(personne);
		}
		
		List<Adresse> listeA  = aDao.findAll();
		System.out.println("Liste des Adresses : ");
		for(Adresse adresse: listeA) {
			System.out.println(adresse);
		}
		
			
		DAOUtil.close();
	}
}
