package fr.eni.demojpa.heritage.joined;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "voituredecourse_hj")
@Table(name = "voituredecourse_hj")
@DiscriminatorValue(value = "C")
public class VoitureDeCourse extends Voiture {
    public String ecurie;
    public VoitureDeCourse() {
    }
    public VoitureDeCourse(String marque, String ecurie) {
        super(marque);
        this.ecurie = ecurie;
    }
    public String getEcurie() {
        return ecurie;
    }
    public void setEcurie(String ecurie) {
        this.ecurie = ecurie;
    }
    @Override
    public String toString() {
        return "VoitureDeCourse [ecurie=" + ecurie + "]";
    }
}
