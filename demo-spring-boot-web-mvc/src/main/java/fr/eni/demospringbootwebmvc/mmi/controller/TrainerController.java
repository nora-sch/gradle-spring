package fr.eni.demospringbootwebmvc.mmi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/trainers")
public class TrainerController {
    @GetMapping
    public String allTrainers() {
        System.out.println("Nous chargerons la liste des formateurs dans une autre démonstration");
        return "view-trainers";
    }

    @GetMapping("/detail")
    public String detailTrainer(
            @RequestParam(name = "email",
                    required = false,
                    defaultValue = "coach@campus-eni.fr") String emailTrainer) {
        System.out.println("Le paramètre - " + emailTrainer);
        return "view-trainer-form";
    }

    //Pour utiliser le membre required = false
    //Il faut mettre les 2 url supportées +
    @GetMapping({"/detail/variable/", "/detail/variable/{email}"})
    public String detailTrainer2(
            @PathVariable(name = "email", required = false) String emailTrainer) {
    //Il n'est pas possible de passer une valeur par défaut si la variable n'existe pas dans URL
    //Il est possible de le faire par codage en testant null
        if(emailTrainer == null) {
            emailTrainer = "coach@campus-eni.fr";
        }
        System.out.println("La variable - " + emailTrainer);
        return "view-trainer-form";
    }

        @PostMapping
    public String createOrUpdateTrainer(
            @RequestParam(required = true) String email,
            @RequestParam(required = true) String firstName,
            @RequestParam(required = true) String lastName) {
        System.out.println("Les paramètres");
        System.out.println("Email - " + email);
        System.out.println("FirstName - " + firstName);
        System.out.println("LastName - " + lastName);
        return "view-trainers";
    }
}
