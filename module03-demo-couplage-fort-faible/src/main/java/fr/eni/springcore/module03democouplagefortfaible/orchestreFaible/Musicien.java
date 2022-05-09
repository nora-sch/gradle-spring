package fr.eni.springcore.module03democouplagefortfaible.orchestreFaible;

public class Musicien {
    private Instrument instrument;
    private String morceau;

    public Musicien(String morceau, Instrument instrument){
        this.instrument = instrument;
        this.morceau = morceau;
    }
    public void jouerMorceau(){
        instrument.afficher();
        System.out.println("et je joue le morceau "+morceau);
        instrument.jouer();
    }
}
