package JPA.Heritage.entity.tableperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity(name="TPCBerlineEntity")
@Table(name="TPCBerline")
public class Berline extends Voiture{
	
	private String couleurCuir;
	
	public Berline(String marque, String couleurCuir) {
		super(marque);
		this.couleurCuir = couleurCuir;
	}
	public Berline() {
		super();
	}
	public String getCouleurCuir() {
		return couleurCuir;
	}
	public void setCouleurCuir(String couleurCuir) {
		this.couleurCuir = couleurCuir;
	}
	
	@Override
	public String toString() {
	return super.toString()+" / "+couleurCuir;
	}

}
