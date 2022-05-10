package fr.eni.demospringbootwebmvc.mmi.converter;

import fr.eni.demospringbootwebmvc.bll.CourseService;
import fr.eni.demospringbootwebmvc.bo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToCourseConverter implements Converter<String, Course> {
    private CourseService service;

    @Autowired
    public void setCourseService(CourseService service) {
        System.out.println("StringToCourseConverter - setCourseService");
        this.service = service;
    }
    @Override
    public Course convert(String id) {
        System.out.println("Convert - "+ id );
        Integer theId = Integer.parseInt(id);
        return service.findById(theId);
    }
}
