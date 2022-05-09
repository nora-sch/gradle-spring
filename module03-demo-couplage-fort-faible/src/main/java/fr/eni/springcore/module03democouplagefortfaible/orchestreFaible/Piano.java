package fr.eni.springcore.module03democouplagefortfaible.orchestreFaible;

public class Piano implements Instrument {
    public void afficher(){
        System.out.println("Je suis un piano...");
    }
    public void jouer(){ System.out.println("LA LA LA"); }
}
