package fr.eni.demospringbeanapplication.bll;

import fr.eni.demospringbeanapplication.bo.Trainer;
import fr.eni.demospringbeanapplication.dal.TrainerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
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
}
