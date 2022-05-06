package JPA.Heritage.entity.joined;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity(name="JoinedBerlineEntity")
@Table(name="JoinedBerline")
@DiscriminatorValue(value="B")
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
