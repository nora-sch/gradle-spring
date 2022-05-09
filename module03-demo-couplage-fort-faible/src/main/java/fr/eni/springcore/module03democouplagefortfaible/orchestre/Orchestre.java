package fr.eni.springcore.module03democouplagefortfaible.orchestre;

import java.util.ArrayList;
import java.util.List;

public class Orchestre {
    private List<Object> listeMusiciens;
    public Orchestre(){
        listeMusiciens = new ArrayList<>();
    }
    public void ajout(Object musicien){
        listeMusiciens.add(musicien);
    }
    public void jouer(){
        for(Object object: listeMusiciens){
            if(object instanceof Pianiste){
                ((Pianiste) object).jouerMorceau();
            }
            if(object instanceof Violoniste){
                ((Violoniste) object).jouerMorceau();
            }
        }
    }

}

