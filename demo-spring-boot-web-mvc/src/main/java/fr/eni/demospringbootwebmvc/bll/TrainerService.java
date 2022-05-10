package fr.eni.demospringbootwebmvc.bll;

import fr.eni.demospringbootwebmvc.bo.Trainer;

import java.util.List;

public interface TrainerService {
    void add(String firstName, String lastName, String email);
    List<Trainer> findAll();
    Trainer findByEmail(String email);
}
