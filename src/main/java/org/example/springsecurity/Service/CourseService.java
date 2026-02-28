package org.example.springsecurity.Service;

import jakarta.transaction.Transactional;
import org.example.springsecurity.Model.Course;
import org.example.springsecurity.Model.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService extends Common{
    @Autowired
    CourseRepository courseRepository;

    public List<Course> getCourses(){
        return courseRepository.findAll();
    }
    @Transactional
    public void addCourse(Course courseReq){
        courseRepository.save(courseReq);
    }

    public void updateCourse(Long id,Course courseReq){
       Course course = getCourse(id);
       String name = courseReq.getName();
       String department = courseReq.getDepartment();
       if(name != null) course.setName(name);
       if(department != null) course.setDepartment(department);
       courseRepository.save(course);
    }

}
