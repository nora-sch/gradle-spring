package fr.eni.demospringbootwebmvc.dal;



import fr.eni.demospringbootwebmvc.bo.Trainer;

import java.util.List;

public interface TrainerDAO {
    void create(Trainer trainer);
    Trainer read(String email);
    void update(Trainer trainer);
    void delete(String email);
    List<Trainer> findAll();
}
