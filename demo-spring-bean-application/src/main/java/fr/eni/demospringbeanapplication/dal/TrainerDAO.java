package fr.eni.demospringbeanapplication.dal;

import fr.eni.demospringbeanapplication.bo.Trainer;

import java.util.List;

public interface TrainerDAO {
    void create(Trainer trainer);
    Trainer read(String email);
    void update(Trainer trainer);
    void delete(String email);
    List<Trainer> findAll();
}
