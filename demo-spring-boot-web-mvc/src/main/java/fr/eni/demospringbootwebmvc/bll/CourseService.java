package fr.eni.demospringbootwebmvc.bll;

import fr.eni.demospringbootwebmvc.bo.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAll();
    Course findById(long id);
}
