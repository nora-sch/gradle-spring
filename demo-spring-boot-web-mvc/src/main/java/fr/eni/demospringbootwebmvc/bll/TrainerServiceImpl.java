package fr.eni.demospringbootwebmvc.bll;


import fr.eni.demospringbootwebmvc.bo.Trainer;
import fr.eni.demospringbootwebmvc.dal.TrainerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Profile("default")
public class TrainerServiceImpl implements TrainerService{
    private TrainerDAO trainerDAO;

    @Autowired
    public TrainerServiceImpl(TrainerDAO trainerDAO){
        this.trainerDAO = trainerDAO;
    }
    @Override
    public void add(String firstName, String lastName, String email) {
        Trainer trainer = new Trainer(firstName, lastName, email);
        trainerDAO.create(trainer);
    }
    @Override
    public List<Trainer> findAll() {
        return trainerDAO.findAll();
    }

    @Override
    public Trainer findByEmail(String emailTrainer) {
        return trainerDAO.read(emailTrainer);

    }
    @Override
    public void update(Trainer trainer) {
        trainerDAO.update(trainer);

    }
}
