package fr.eni.springcore.module03democouplagefortfaible.orchestre;

public class Violoniste {
    private Violon violon;
    private String morceau;
    public Violoniste(String morceau){
        this.violon = new Violon();
        this.morceau = morceau;
    }
    public void jouerMorceau(){
        violon.afficher();
        System.out.println(" et je joue le morceau "+morceau);
        violon.jouer();
    }
}
