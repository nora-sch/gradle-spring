package com.eni.demojpa.heritage.tableperclass;

import javax.persistence.Entity;

@Entity
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
