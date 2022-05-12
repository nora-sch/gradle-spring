package fr.eni.demojpa;

import fr.eni.demojpa.key1.PersonnePK1Repository;
import fr.eni.demojpa.key2.PersonnePK2Repository;
import fr.eni.demojpa.oneone.bi.PersonneOTOBiRepository;
import fr.eni.demojpa.oneone.uni.PersonneOTOURepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;

@SpringBootApplication
public class DemoJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoJpaApplication.class, args);
       }

    @Bean
    @Profile("demo")
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
    @Profile("demo")
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

    @Bean
    @Profile("demo")
    public CommandLineRunner demoOneToOneUni(PersonneOTOURepository repository) {
        return (args) -> {
            fr.eni.demojpa.oneone.uni.Adresse a1 = new fr.eni.demojpa.oneone.uni.Adresse("75000", "Paris");
            fr.eni.demojpa.oneone.uni.Adresse a2 = new fr.eni.demojpa.oneone.uni.Adresse("35000", "Rennes");
            fr.eni.demojpa.oneone.uni.Personne p1 = new fr.eni.demojpa.oneone.uni.Personne ("Legrand", "Lucie",
                    LocalDate.parse("2008-06-18"), a1);
            fr.eni.demojpa.oneone.uni.Personne p2 = new fr.eni.demojpa.oneone.uni.Personne ("Legrand", "Lucie2",
                    LocalDate.parse("2006-04-03"), a2);
            repository.save(p1);
            repository.save(p2);
            // fetch all
            System.out.println("Liste des personnes : ");
            System.out.println("-------------------------------");
            for (fr.eni.demojpa.oneone.uni.Personne p : repository.findAll()) {
                System.out.println(p.toString());
            }
        };
    }
    @Bean
    public CommandLineRunner demoOneToOneBi(PersonneOTOBiRepository repository) {
        return (args) -> {
            fr.eni.demojpa.oneone.bi.Adresse a1 = new fr.eni.demojpa.oneone.bi.Adresse("75000", "Paris");
            fr.eni.demojpa.oneone.bi.Adresse a2 = new fr.eni.demojpa.oneone.bi.Adresse("35000", "Rennes");
            fr.eni.demojpa.oneone.bi.Personne p1 = new fr.eni.demojpa.oneone.bi.Personne("Legrand", "Lucie",
                    LocalDate.parse("2008-06-18"), a1);
            fr.eni.demojpa.oneone.bi.Personne p2 = new fr.eni.demojpa.oneone.bi.Personne("Legrand", "Lucie2",
                    LocalDate.parse("2006-04-03"), a2);
            repository.save(p1);
            repository.save(p2);
// fetch all
            System.out.println("Liste des personnes : ");
            System.out.println("-------------------------------");
            for (fr.eni.demojpa.oneone.bi.Personne p : repository.findAll()) {
                System.out.println(p.toString());
            }
            System.out.println("\nTestons la relation bidirectionnelle -- Affichage a2 et de sa personne");
            System.out.println("-------------------------------");
            System.out.println(a2);
            System.out.println(a2.getPersonne());
        };
    }


    }
