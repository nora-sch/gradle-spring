package fr.eni.demojpa;

import fr.eni.demojpa.key1.PersonnePK1Repository;
import fr.eni.demojpa.key2.PersonnePK2Repository;
import fr.eni.demojpa.oneone.bi.PersonneOTOBiRepository;
import fr.eni.demojpa.oneone.uni.PersonneOTOURepository;
import fr.eni.demojpa.otm.bi.AdresseOTMBiRepository;
import fr.eni.demojpa.otm.bi.PersonneOTMBiRepository;
import fr.eni.demojpa.otm.uni.Adresse;
import fr.eni.demojpa.otm.uni.AdresseOTMURepository;
import fr.eni.demojpa.otm.uni.PersonneOTMURepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.ArrayList;

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
    @Profile("demo")
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
    @Bean
    @Profile("demo")
    public CommandLineRunner demoOneToManyUni(PersonneOTMURepository persDAO,
                                              AdresseOTMURepository adresseDAO) {
        return (args) -> {
// save a few customers
            fr.eni.demojpa.otm.uni.Adresse a1 = new fr.eni.demojpa.otm.uni.Adresse("44000", "Nantes");
            fr.eni.demojpa.otm.uni.Adresse a2 = new fr.eni.demojpa.otm.uni.Adresse("33000", "Bordeaux");
            fr.eni.demojpa.otm.uni.Adresse a3 = new fr.eni.demojpa.otm.uni.Adresse("29000", "Brest");
            fr.eni.demojpa.otm.uni.Adresse a4 = new fr.eni.demojpa.otm.uni.Adresse("74000", "Chamonix");
            fr.eni.demojpa.otm.uni.Personne albert = new fr.eni.demojpa.otm.uni.Personne("Dupontel","Albert");
            fr.eni.demojpa.otm.uni.Personne sophie = new fr.eni.demojpa.otm.uni.Personne("Marceau","Sophie");
            albert.addAdresse(a1);
            albert.addAdresse(a2);
            sophie.addAdresse(a3);
            sophie.addAdresse(a4);
            persDAO.save(albert);
            persDAO.save(sophie);

            //Tester l'attribut : orphan
            albert.setAdresses(new ArrayList< Adresse>());
            persDAO.save(albert);
            System.out.println("Détachement des adresses de albert : ");
            System.out.println("-------------------------------");
            for (fr.eni.demojpa.otm.uni.Adresse adr : adresseDAO.findAll()) {
                System.out.println(adr.toString());
            }

            System.out.println("Liste des personnes : ");
            System.out.println("-------------------------------");
            for (fr.eni.demojpa.otm.uni.Personne personne : persDAO.findAll()) {
                System.out.println(personne.toString());
            }
        };
    }
    @Bean
    public CommandLineRunner demoOneToManyBi(PersonneOTMBiRepository persDAO, AdresseOTMBiRepository
            adresseDAO) {
        return (args) -> {
// save a few customers
            fr.eni.demojpa.otm.bi.Adresse a1 = new fr.eni.demojpa.otm.bi.Adresse("44000", "Nantes");
            fr.eni.demojpa.otm.bi.Adresse a2 = new fr.eni.demojpa.otm.bi.Adresse("33000", "Bordeaux");
            fr.eni.demojpa.otm.bi.Adresse a3 = new fr.eni.demojpa.otm.bi.Adresse("29000", "Brest");
            fr.eni.demojpa.otm.bi.Adresse a4 = new fr.eni.demojpa.otm.bi.Adresse("74000", "Chamonix");
            fr.eni.demojpa.otm.bi.Personne albert = new fr.eni.demojpa.otm.bi.Personne("Dupontel", "Albert");
            fr.eni.demojpa.otm.bi.Personne sophie = new fr.eni.demojpa.otm.bi.Personne("Marceau", "Sophie");
            albert.addAdresse(a1);
            albert.addAdresse(a2);
            sophie.addAdresse(a3);
            sophie.addAdresse(a4);
            persDAO.save(albert);
            persDAO.save(sophie);
            System.out.println("Liste des personnes : ");
            System.out.println("-------------------------------");
            for (fr.eni.demojpa.otm.bi.Personne personne : persDAO.findAll()) {
                System.out.println(personne.toString());
            }
            System.out.println("\nTestons la relation bidirectionnelle -- Affichage a2 et de sa personne");
            System.out.println("-------------------------------");
            System.out.println(a2);
            System.out.println(a2.getPersonne());
            // Tester l'attribut : orphan
            albert.setAdresses(new ArrayList<fr.eni.demojpa.otm.bi.Adresse>());
            persDAO.save(albert);
            System.out.println("Détachement des adresses de albert : ");
            System.out.println("-------------------------------");
            for (fr.eni.demojpa.otm.bi.Adresse adr : adresseDAO.findAll()) {
                System.out.println(adr.toString());
            }
        };
    }


}
