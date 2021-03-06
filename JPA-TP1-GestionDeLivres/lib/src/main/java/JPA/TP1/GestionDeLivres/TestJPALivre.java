package JPA.TP1.GestionDeLivres;

import java.util.List;

import JPA.TP1.GestionDeLivres.dao.LivreDAO;
import JPA.TP1.GestionDeLivres.entity.Livre;


public class TestJPALivre extends LivreDAO{
	
	public static void main(String[] args) throws DAOException {
		
		LivreDAO livreDao = new LivreDAO();
		
		System.out.println("Cr?ation de 4 livres :");
		Livre l1 = new Livre("Emile Zola", "La b?te humaine", 450); 
		System.out.println(l1);
		Livre l2 = new Livre("JP Sartre", "Huis Clos", 350); 
		System.out.println(l2);
		Livre l3 = new Livre("Albert Camus", "L'?tranger", 476); 
		System.out.println(l3);
		Livre l4 = new Livre("Albert Camus", "La Peste", 276); 
		System.out.println(l4);
		// add
		 try {
			 	insert(l1);
				insert(l2);
				insert(l3);
				insert(l4); 
		 }catch(DAOException e) {
			 System.out.println(e.getMessage());
		 }
		 
		// display
		List<Livre> liste = livreDao.findAll();
		displayList("Liste des livres : ", liste);
		displayList("Liste des livres tri?s par titre ascendant : ", livreDao.findAllOrderByTitreAsc());
		displayList("Liste des livres tri?s par titre descendant : ", livreDao.findAllOrderByTitreDesc());
		displayList("Liste des livres de Camus : ", livreDao.findByAuteurLike("Camus"));
		System.out.println("premier id : "+livreDao.getMinId());
		System.out.println("dernier id : "+livreDao.getMaxId());
		System.out.println("livre id = 2 : " + livreDao.findById(2));
		System.out.println("livre id = 22 : " + livreDao.findById(22));
		
		// delete		
		 try {
			 livreDao.delete(l1);
		 }catch(DAOException e) {
			 System.out.println(e.getMessage());
		 }

		 try {
			 livreDao.deleteById(3);
		 }catch(DAOException e) {
			 System.out.println(e.getMessage());
		 }
		 
		 // update
		 l2.setAuteur("Jean-Paul Sartre");
		 l2.setNbPages(354);
		 try {
			 livreDao.update(l2);
		 }catch(DAOException e) {
			 System.out.println(e.getMessage());
		 }
		 
		 // display modifications
		 displayList("Liste des livres apr?s la modification: ", livreDao.findAll());
	}
	
	private static void displayList(String msg, List<Livre> liste) {
		System.out.println(msg);
		 for(Livre livre : liste) {
			 System.out.println(livre);
		 }
	}
	
}
