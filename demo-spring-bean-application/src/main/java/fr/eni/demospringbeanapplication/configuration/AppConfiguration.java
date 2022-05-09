package fr.eni.demospringbeanapplication.configuration;

import fr.eni.demospringbeanapplication.bll.TrainerService;
import fr.eni.demospringbeanapplication.bll.TrainerServiceImpl;
import fr.eni.demospringbeanapplication.bll.mock.TrainerServiceMock;
import fr.eni.demospringbeanapplication.dal.TrainerDAO;
import fr.eni.demospringbeanapplication.dal.mock.TrainerDAOMock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfiguration {
    @Bean
    public TrainerDAO getBeanTrainerDAO() {
        return new TrainerDAOMock();
    }
    @Bean
    @Profile("default")
    public TrainerService getBeanTrainerService() {
        return new TrainerServiceImpl(getBeanTrainerDAO());
    }
    @Bean
    @Profile("dev")
    public TrainerService getBeanTrainerServiceMock() {
        return new TrainerServiceMock();
    }

}
