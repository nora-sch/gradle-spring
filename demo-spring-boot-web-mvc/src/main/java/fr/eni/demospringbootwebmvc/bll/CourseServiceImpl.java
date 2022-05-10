package fr.eni.demospringbootwebmvc.bll;

import fr.eni.demospringbootwebmvc.bo.Course;
import fr.eni.demospringbootwebmvc.dal.CourseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    private CourseDAO courseDAO;
    @Autowired
    public CourseServiceImpl(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    @Override
    public List<Course> findAll() {
        return courseDAO.findAll();
    }

    @Override
    public Course findById(long id) {
        return  courseDAO.read(id);
    }
}
