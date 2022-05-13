package fr.eni.demojpa;

import com.eni.demojpa.otm.uni.Personne;
import com.eni.demojpa.key1.PersonnePK1Repository;
import com.eni.demojpa.key2.PersonnePK2Repository;
import com.eni.demojpa.oneone.bi.PersonneOTOBiRepository;
import com.eni.demojpa.oneone.uni.PersonneOTOURepository;
import com.eni.demojpa.otm.bi.AdresseOTMBiRepository;
import com.eni.demojpa.otm.bi.PersonneOTMBiRepository;
import com.eni.demojpa.otm.uni.Adresse;
import com.eni.demojpa.otm.uni.AdresseOTMURepository;
import com.eni.demojpa.otm.uni.PersonneOTMURepository;
import fr.eni.demojpa.mto.CiviliteMTORepository;
import fr.eni.demojpa.mto.PersonneMTORepository;
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
            repository.save(new com.eni.demojpa.key1.Personne("Legrand", "Lucie", LocalDate.parse("2008-06-18")));
            repository.save(new com.eni.demojpa.key1.Personne("Legrand", "Lucie2", LocalDate.parse("2006-04-03")));
            // fetch all customers
            // sysout //("Customers found with findAll():");
            System.out.println("Liste des personnes : ");
            System.out.println("-------------------------------");
            for (com.eni.demojpa.key1.Personne p : repository.findAll()) {
                System.out.println(p.toString());
            }
        };
    }


    @Bean
    @Profile("demo")
    public CommandLineRunner demoKey2(PersonnePK2Repository repository) {
        return (args) -> {
            // save a few customers
            repository.save(new com.eni.demojpa.key2.Personne("Legrand", "Lucie", LocalDate.parse("2008-06-18")));
            repository.save(new com.eni.demojpa.key2.Personne("Legrand", "Lucie2", LocalDate.parse("2006-04-03")));
            // fetch all customers
            // sysout //("Customers found with findAll():");
            System.out.println("Liste des personnes : ");
            System.out.println("-------------------------------");
            for (com.eni.demojpa.key2.Personne p : repository.findAll()) {
                System.out.println(p.toString());
            }
        };
    }

    @Bean
    @Profile("demo")
    public CommandLineRunner demoOneToOneUni(PersonneOTOURepository repository) {
        return (args) -> {
            com.eni.demojpa.oneone.uni.Adresse a1 = new com.eni.demojpa.oneone.uni.Adresse("75000", "Paris");
            com.eni.demojpa.oneone.uni.Adresse a2 = new com.eni.demojpa.oneone.uni.Adresse("35000", "Rennes");
            com.eni.demojpa.oneone.uni.Personne p1 = new com.eni.demojpa.oneone.uni.Personne("Legrand", "Lucie",
                    LocalDate.parse("2008-06-18"), a1);
            com.eni.demojpa.oneone.uni.Personne p2 = new com.eni.demojpa.oneone.uni.Personne("Legrand", "Lucie2",
                    LocalDate.parse("2006-04-03"), a2);
            repository.save(p1);
            repository.save(p2);
            // fetch all
            System.out.println("Liste des personnes : ");
            System.out.println("-------------------------------");
            for (com.eni.demojpa.oneone.uni.Personne p : repository.findAll()) {
                System.out.println(p.toString());
            }
        };
    }
    @Bean
    @Profile("demo")
    public CommandLineRunner demoOneToOneBi(PersonneOTOBiRepository repository) {
        return (args) -> {
            com.eni.demojpa.oneone.bi.Adresse a1 = new com.eni.demojpa.oneone.bi.Adresse("75000", "Paris");
            com.eni.demojpa.oneone.bi.Adresse a2 = new com.eni.demojpa.oneone.bi.Adresse("35000", "Rennes");
            com.eni.demojpa.oneone.bi.Personne p1 = new com.eni.demojpa.oneone.bi.Personne("Legrand", "Lucie",
                    LocalDate.parse("2008-06-18"), a1);
            com.eni.demojpa.oneone.bi.Personne p2 = new com.eni.demojpa.oneone.bi.Personne("Legrand", "Lucie2",
                    LocalDate.parse("2006-04-03"), a2);
            repository.save(p1);
            repository.save(p2);
// fetch all
            System.out.println("Liste des personnes : ");
            System.out.println("-------------------------------");
            for (com.eni.demojpa.oneone.bi.Personne p : repository.findAll()) {
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
            Adresse a1 = new Adresse("44000", "Nantes");
            Adresse a2 = new Adresse("33000", "Bordeaux");
            Adresse a3 = new Adresse("29000", "Brest");
            Adresse a4 = new Adresse("74000", "Chamonix");
            Personne albert = new Personne("Dupontel","Albert");
            Personne sophie = new Personne("Marceau","Sophie");
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
            for (Adresse adr : adresseDAO.findAll()) {
                System.out.println(adr.toString());
            }

            System.out.println("Liste des personnes : ");
            System.out.println("-------------------------------");
            for (Personne personne : persDAO.findAll()) {
                System.out.println(personne.toString());
            }
        };
    }
    @Bean
    @Profile("demo")
    public CommandLineRunner demoOneToManyBi(PersonneOTMBiRepository persDAO, AdresseOTMBiRepository adresseDAO) {
        return (args) -> {
// save a few customers
            com.eni.demojpa.otm.bi.Adresse a1 = new com.eni.demojpa.otm.bi.Adresse("44000", "Nantes");
            com.eni.demojpa.otm.bi.Adresse a2 = new com.eni.demojpa.otm.bi.Adresse("33000", "Bordeaux");
            com.eni.demojpa.otm.bi.Adresse a3 = new com.eni.demojpa.otm.bi.Adresse("29000", "Brest");
            com.eni.demojpa.otm.bi.Adresse a4 = new com.eni.demojpa.otm.bi.Adresse("74000", "Chamonix");
            com.eni.demojpa.otm.bi.Personne albert = new com.eni.demojpa.otm.bi.Personne("Dupontel", "Albert");
            com.eni.demojpa.otm.bi.Personne sophie = new com.eni.demojpa.otm.bi.Personne("Marceau", "Sophie");
            albert.addAdresse(a1);
            albert.addAdresse(a2);
            sophie.addAdresse(a3);
            sophie.addAdresse(a4);
            persDAO.save(albert);
            persDAO.save(sophie);
            System.out.println("Liste des personnes : ");
            System.out.println("-------------------------------");
            for (com.eni.demojpa.otm.bi.Personne personne : persDAO.findAll()) {
                System.out.println(personne.toString());
            }
            System.out.println("\nTestons la relation bidirectionnelle -- Affichage a2 et de sa personne");
            System.out.println("-------------------------------");
            System.out.println(a2);
            System.out.println(a2.getPersonne());
            // Tester l'attribut : orphan
            albert.setAdresses(new ArrayList<com.eni.demojpa.otm.bi.Adresse>());
            persDAO.save(albert);
            System.out.println("Détachement des adresses de albert : ");
            System.out.println("-------------------------------");
            for (com.eni.demojpa.otm.bi.Adresse adr : adresseDAO.findAll()) {
                System.out.println(adr.toString());
            }
        };
    }

    @Bean
    public CommandLineRunner demoManyToOne(PersonneMTORepository persDAO, CiviliteMTORepository civiliteDAO) {
        return (args) -> {
            fr.eni.demojpa.mto.Civilite c1 = new fr.eni.demojpa.mto.Civilite("M", "Monsieur");
            fr.eni.demojpa.mto.Civilite c2 = new fr.eni.demojpa.mto.Civilite("Mme", "Madame");
            civiliteDAO.save(c1);
            civiliteDAO.save(c2);
            fr.eni.demojpa.mto.Personne albert = new fr.eni.demojpa.mto.Personne("Dupontel", "Albert");
            fr.eni.demojpa.mto.Personne jack = new fr.eni.demojpa.mto.Personne("Lemmon", "Jack");
            fr.eni.demojpa.mto.Personne sophie = new fr.eni.demojpa.mto.Personne("Marceau", "Sophie");
            albert.setCivilite(c1);
            sophie.setCivilite(c2);
            jack.setCivilite(c1);
            persDAO.save(albert);
            persDAO.save(sophie);
            persDAO.save(jack);
            System.out.println("Liste des personnes : ");
            System.out.println("-------------------------------");
            for (fr.eni.demojpa.mto.Personne personne : persDAO.findAll()) {
                System.out.println(personne.toString());
            }
            persDAO.delete(sophie);
            System.out.println("Liste des personnes après suppression de sophie : ");
            System.out.println("-------------------------------");
            for (fr.eni.demojpa.mto.Personne personne : persDAO.findAll()) {
                System.out.println(personne.toString());
            }
            System.out.println("Liste des civilités : ");
            System.out.println("-------------------------------");
            for (fr.eni.demojpa.mto.Civilite c : civiliteDAO.findAll()) {
                System.out.println(c.toString());
            }
        };
    }

        }
