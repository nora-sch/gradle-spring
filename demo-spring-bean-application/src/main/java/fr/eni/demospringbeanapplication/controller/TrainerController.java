package fr.eni.demospringbeanapplication.controller;

import fr.eni.demospringbeanapplication.bll.TrainerService;
import fr.eni.demospringbeanapplication.bo.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TrainerController {
    private TrainerService trainerService;

    // injection dependance par constructeur
    @Autowired
    public TrainerController(TrainerService trainerService){
        System.out.println("Appel du construteur TrainerController");
        this.trainerService = trainerService;
    }
    public void showAllTrainers() {
        List<Trainer> lstTrainers = trainerService.findAll();
        System.out.println(lstTrainers);
    }

    /*
    // injection dependance par setter
    @Autowired
    public void setTrainerService(TrainerService trainerService) {
        System.out.println("Appel de setTrainerService");
        this.trainerService = trainerService;
    }*/

}
