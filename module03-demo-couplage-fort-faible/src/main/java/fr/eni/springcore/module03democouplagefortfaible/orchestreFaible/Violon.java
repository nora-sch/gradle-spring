package fr.eni.springcore.module03democouplagefortfaible.orchestreFaible;

public class Violon implements Instrument {
    public void afficher(){System.out.println("Je suis un violon...");}
    public void jouer(){
        System.out.println("ZIN ZIN ZIN");
    }
}
