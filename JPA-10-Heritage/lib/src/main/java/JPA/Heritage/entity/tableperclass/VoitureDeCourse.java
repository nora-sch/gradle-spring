package JPA.Heritage.entity.tableperclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity(name="TPCVoitureDeCourseEntity")
@Table(name="TPCVoitureDeCourse")
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
	return super.toString()+" / "+ecurie;
	}
	
}
