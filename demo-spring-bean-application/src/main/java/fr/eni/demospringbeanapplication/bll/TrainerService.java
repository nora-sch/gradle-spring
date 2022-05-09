package fr.eni.demospringbeanapplication.bll;

import fr.eni.demospringbeanapplication.bo.Trainer;
import java.util.List;

public interface TrainerService {
    void add(String firstName, String lastName, String email);
    List<Trainer> findAll();
}
