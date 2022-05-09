package fr.eni.springcore.module03democouplagefortfaible.orchestreFaible;

import fr.eni.springcore.module03democouplagefortfaible.orchestreForte.Pianiste;
import fr.eni.springcore.module03democouplagefortfaible.orchestreForte.Violoniste;

import java.util.ArrayList;
import java.util.List;

public class Orchestre {
    private List<Musicien> listeMusiciens;
    public Orchestre(){
        listeMusiciens = new ArrayList<>();
    }
    public void ajout(Musicien musicien){
        listeMusiciens.add(musicien);
    }
    public void jouer(){
        for(Musicien musicien: listeMusiciens){
             musicien.jouerMorceau();
        }
    }
}

