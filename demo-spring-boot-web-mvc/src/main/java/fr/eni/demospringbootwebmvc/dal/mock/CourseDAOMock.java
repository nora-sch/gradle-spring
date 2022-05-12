package fr.eni.demospringbootwebmvc.dal.mock;

import fr.eni.demospringbootwebmvc.bo.Course;
import fr.eni.demospringbootwebmvc.dal.CourseDAO;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("dev")
public class CourseDAOMock implements CourseDAO {

    private static List<Course> lstCourses;
    public CourseDAOMock() {
        lstCourses = new ArrayList<Course>();
        lstCourses.add(new Course(10, "Algorithmique", 5));
        lstCourses.add(new Course(20, "Initiation à la programmation", 5));
        lstCourses.add(new Course(30, "POO", 10));
        lstCourses.add(new Course(50, "SQL", 5));
        lstCourses.add(new Course(60, "PL-SQL", 5));
        lstCourses.add(new Course(130, "Web Client", 5));
        lstCourses.add(new Course(140, "Symfony", 10));
        lstCourses.add(new Course(220, "frameworks Java EE", 10));
    }

    @Override
    public Course read(long id) {
        for (Course course : lstCourses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    @Override
    public List<Course> findAll() {
        return lstCourses;
    }
}
