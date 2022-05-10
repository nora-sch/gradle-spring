package fr.eni.demospringbootwebmvc.dal;

import fr.eni.demospringbootwebmvc.bo.Course;

import java.util.List;

public interface CourseDAO {
    Course read(long id);
    List<Course> findAll();
}
