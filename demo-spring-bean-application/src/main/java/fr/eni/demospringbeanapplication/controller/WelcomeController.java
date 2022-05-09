package fr.eni.demospringbeanapplication.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component()
@Scope("prototype")
public class WelcomeController {
    public void welcome(){
        System.out.println("Bienvenue dans la démonstration de Container");
    }

}
