package fr.eni.demospringbeanapplication.bll.mock;

import fr.eni.demospringbeanapplication.bll.TrainerService;
import fr.eni.demospringbeanapplication.bo.Trainer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TrainerServiceMock implements TrainerService {

    // Solution temporaire - gestion d'une liste de formateur locale
    private static List<Trainer> lstTrainers;

    public TrainerServiceMock() {
        lstTrainers = new ArrayList<Trainer>();
        lstTrainers.add(new Trainer("Anne-Lise", "Baille", "abaille@campus-eni.fr"));
        lstTrainers.add(new Trainer("Stéphane", "Gobin", "sgobin@campus-eni.fr"));
    }
    @Override
    public void add(String firstName, String lastName, String email) {
        Trainer t = new Trainer(firstName, lastName, email);
        lstTrainers.add(t);
    }
    @Override
    public List<Trainer> findAll() {
        return lstTrainers;
    }
}
