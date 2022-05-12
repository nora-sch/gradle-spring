package fr.eni.demojpa;

import fr.eni.demojpa.key1.PersonnePK1Repository;
import fr.eni.demojpa.key2.PersonnePK2Repository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class DemoJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoJpaApplication.class, args);
       }

    @Bean
    public CommandLineRunner demoKey1(PersonnePK1Repository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new fr.eni.demojpa.key1.Personne("Legrand", "Lucie", LocalDate.parse("2008-06-18")));
            repository.save(new fr.eni.demojpa.key1.Personne("Legrand", "Lucie2", LocalDate.parse("2006-04-03")));
            // fetch all customers
            // sysout //("Customers found with findAll():");
            System.out.println("Liste des personnes : ");
            System.out.println("-------------------------------");
            for (fr.eni.demojpa.key1.Personne p : repository.findAll()) {
                System.out.println(p.toString());
            }
        };
    }


    @Bean
    public CommandLineRunner demoKey2(PersonnePK2Repository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new fr.eni.demojpa.key2.Personne("Legrand", "Lucie", LocalDate.parse("2008-06-18")));
            repository.save(new fr.eni.demojpa.key2.Personne("Legrand", "Lucie2", LocalDate.parse("2006-04-03")));
            // fetch all customers
            // sysout //("Customers found with findAll():");
            System.out.println("Liste des personnes : ");
            System.out.println("-------------------------------");
            for (fr.eni.demojpa.key2.Personne p : repository.findAll()) {
                System.out.println(p.toString());
            }
        };
    }

}
