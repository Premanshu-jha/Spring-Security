package org.example.springsecurity.Service;

import jakarta.transaction.Transactional;
import org.example.springsecurity.Model.Course;
import org.example.springsecurity.Model.CourseRepository;
import org.example.springsecurity.Model.Student;
import org.example.springsecurity.Model.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseService extends Common{
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    public List<Course> getCourses(Long studentId){
        return courseRepository.findAllByStudents_Id(studentId);
    }
    @Transactional
    public void addCourse(Long studentId,Course courseReq){
        Student student = getStudent(studentId);
        Course course = courseRepository.findByName(courseReq.getName())
                .orElseGet(()->courseRepository.save(courseReq));
        student.getCourses().add(course);
        course.getStudents().add(student);

        studentRepository.save(student);
    }

    public void updateCourse(Long id,Course courseReq){
       Course course = courseRepository.findById(id).orElseThrow(()->new RuntimeException("No course with the given id exist"));
       String name = courseReq.getName();
       String department = courseReq.getDepartment();
       if(name != null) course.setName(name);
       if(department != null) course.setDepartment(department);

       courseRepository.save(course);
    }

}
