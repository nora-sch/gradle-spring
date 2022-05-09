package fr.eni.springcore.module03democouplagefortfaible.orchestre;

public class Pianiste {
    private Piano piano;
    private String morceau;
    public Pianiste(String morceau){
        this.piano = new Piano();
        this.morceau = morceau;
    }
    public void jouerMorceau(){
        piano.afficher();
        System.out.println(" et je joue le morceau "+morceau);
        piano.jouer();
    }
}
