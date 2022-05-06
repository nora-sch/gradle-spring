package JPA.Heritage.entity.single;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


@Entity
@DiscriminatorValue(value="C")
public class VoitureDeCourse extends Voiture {

private String ecurie;
	
	public VoitureDeCourse(String marque, String ecurie) {
		super(marque);
		this.ecurie = ecurie;
	}
	public VoitureDeCourse() {
		super();
	}
	
	
	public String getEcurie() {
		return ecurie;
	}
	public void setEcurie(String ecurie) {
		this.ecurie = ecurie;
	}
	
	@Override
	public String toString() {
	return super.toString()+" "+ecurie;
	}
	
}
