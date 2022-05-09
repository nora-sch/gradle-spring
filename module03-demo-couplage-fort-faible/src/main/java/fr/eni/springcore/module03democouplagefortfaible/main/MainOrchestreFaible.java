package fr.eni.springcore.module03democouplagefortfaible.main;


import fr.eni.springcore.module03democouplagefortfaible.orchestreFaible.Musicien;
import fr.eni.springcore.module03democouplagefortfaible.orchestreFaible.Orchestre;
import fr.eni.springcore.module03democouplagefortfaible.orchestreFaible.Piano;
import fr.eni.springcore.module03democouplagefortfaible.orchestreFaible.Violon;

public class MainOrchestreFaible {
    public static void main(String[] args){
    System.out.println("Le pianiste : ");
    Musicien pianiste = new Musicien("La 9eme de Beethoven", new Piano());
    pianiste.jouerMorceau();

    System.out.println("Le violoniste : ");
    Musicien violoniste = new Musicien("La 9eme de Beethoven", new Violon());
    violoniste.jouerMorceau();

    System.out.println("L'orchestre' : ");
    Orchestre orchestre = new Orchestre();
    orchestre.ajout(pianiste);
    orchestre.ajout(violoniste);
    orchestre.jouer();
}
}
