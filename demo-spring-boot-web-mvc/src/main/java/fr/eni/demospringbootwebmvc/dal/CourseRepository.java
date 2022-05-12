package fr.eni.demospringbootwebmvc.dal;

import fr.eni.demospringbootwebmvc.bo.Course;
import org.springframework.data.jpa.repository.JpaRepository;

//Création de l'interface pour utiliser ORM JPA
public interface CourseRepository extends JpaRepository<Course, Long> {

}
