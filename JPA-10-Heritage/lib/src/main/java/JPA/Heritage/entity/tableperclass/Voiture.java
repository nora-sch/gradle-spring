package JPA.Heritage.entity.tableperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity(name="TPCVoitureEntity")
@Table(name="TPCVoiture")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Voiture {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	private String marque;
	
	public Voiture() {
	}
	
	public Voiture(String marque) {
		this.marque = marque;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}
	
@Override
public String toString() {
return "Voiture - "+id+" : "+marque;
}
	
	
}
