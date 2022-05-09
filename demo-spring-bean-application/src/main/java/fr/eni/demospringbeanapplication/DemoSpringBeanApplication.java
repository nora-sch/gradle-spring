package fr.eni.demospringbeanapplication;


import fr.eni.demospringbeanapplication.controller.TrainerController;
import fr.eni.demospringbeanapplication.controller.WelcomeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoSpringBeanApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(DemoSpringBeanApplication.class, args);
        TrainerController trainerCtrler = ctx.getBean(TrainerController.class);
        trainerCtrler.showAllTrainers();
        //Injection par nom
        //WelcomeController welcomeCtrler = (WelcomeController) ctx.getBean("welcomeControllerBean");
        //welcomeCtrler.welcome();

        //Injection par type
        WelcomeController welcomeCtrler = ctx.getBean(WelcomeController.class);
        welcomeCtrler.welcome();

        // Singleton
        WelcomeController welcomeCtrler1 = ctx.getBean(WelcomeController.class);
        System.out.println("welcomeCtrler1=" + welcomeCtrler1.toString());
        WelcomeController welcomeCtrler2 = ctx.getBean(WelcomeController.class);
        System.out.println("welcomeCtrler2=" + welcomeCtrler2.toString());

    }

}
