package fr.eni.demospringbootwebmvc.bll;

import fr.eni.demospringbootwebmvc.bo.Course;
import fr.eni.demospringbootwebmvc.dal.CourseDAO;
import fr.eni.demospringbootwebmvc.dal.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    private CourseRepository courseDAO;
    @Autowired
    public CourseServiceImpl(CourseRepository courseDAO) {
        this.courseDAO = courseDAO;
    }

    @Override
    public List<Course> findAll() {
        return courseDAO.findAll();
    }

    @Override
    public Course findById(long id) {
        return  courseDAO.getById(id);
    }
}
