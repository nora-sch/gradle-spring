package JPA.CollectionEnBase;

import java.util.ArrayList;
import java.util.List;

import JPA.CollectionEnBase.dao.DAOUtil;
import JPA.CollectionEnBase.dao.PersonneDAO;
import JPA.CollectionEnBase.entity.Personne;

public class TestPersonne {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		
	List<String> listeSports1 = new ArrayList<String>();
	listeSports1.add("Athletisme");
	listeSports1.add("Judo");
	listeSports1.add("Badminton");
	listeSports1.add("Hand-ball");  
	Personne p1 = new Personne("Lebrun", "Jeanne", listeSports1); 
		
	List<String> listeSports2 = new ArrayList<String>();
	listeSports2.add("Football");
	listeSports2.add("Judo");
	listeSports2.add("Badminton");
	listeSports2.add("Hand-ball");  
	Personne p2 = new Personne("Lepetit", "Aline", listeSports2); 
			
		try {
			PersonneDAO.add(p1);
			PersonneDAO.add(p2);
			PersonneDAO.delete(p1);
			}catch(Exception e) {
			e.printStackTrace();
		}
				
		DAOUtil.close();
	}
}
