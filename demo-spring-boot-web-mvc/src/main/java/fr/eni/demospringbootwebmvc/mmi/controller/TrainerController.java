package fr.eni.demospringbootwebmvc.mmi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TrainerController {
    @GetMapping("/trainers")
    public String allTrainers() {
        System.out.println("Nous chargerons la liste des formateurs dans une autre démonstration");
        return "view-trainers";
    }
}
