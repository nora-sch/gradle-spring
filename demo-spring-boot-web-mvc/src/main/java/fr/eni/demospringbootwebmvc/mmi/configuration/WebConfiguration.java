package fr.eni.demospringbootwebmvc.mmi.configuration;

import fr.eni.demospringbootwebmvc.bo.Course;
import fr.eni.demospringbootwebmvc.dal.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Bean
    public LocaleResolver localeResolver() {
        System.out.println("localeResolver");
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(new Locale("fr"));
        return slr;
    }
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("language");
        return localeChangeInterceptor;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    //Pour injecter par défaut des cours en base.
    @Bean
    public CommandLineRunner demo(CourseRepository repository) {
        return (args) -> {
    // ajouter des cours
            repository.save(new Course(10, "Algorithmique", 5));
            repository.save(new Course(20, "Initiation à la programmation", 5));
            repository.save(new Course(30, "POO", 10));
            repository.save(new Course(50, "SQL", 5));
            repository.save(new Course(60, "PL-SQL", 5));
            repository.save(new Course(130, "Web Client", 5));
            repository.save(new Course(140, "Symfony", 10));
            repository.save(new Course(220, "frameworks Java EE", 10));
            // Tracer la liste créée
            System.out.println("Liste des cours : ");
            repository.findAll().forEach(course -> System.out.println(course));
        };
    }

    }
