package org.example.springsecurity.Service;

import jakarta.transaction.Transactional;
import org.example.springsecurity.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseEnrollmentService extends Common{

    @Autowired
    CourseEnrollmentRepository courseEnrollmentRepository;

    public List<CourseEnrollment> getAllCourseEnrollments(){
         return courseEnrollmentRepository.findAll();
    }


    @Transactional
    public void addCourseEnrollment(Long studentId,Long courseId){
        Student student = getStudent(studentId);
        Course course = getCourse(courseId);

        CourseEnrollment ce = new CourseEnrollment();
        ce.setCourseEnrollmentId(new CourseEnrollmentId(student.getId(), course.getId()));
        ce.setStudent(student);
        ce.setCourse(course);

        courseEnrollmentRepository.save(ce);
    }

    public void unEnrollCourse(Long studentId,Long courseId){
        CourseEnrollmentId courseEnrollmentId = new CourseEnrollmentId(studentId,courseId);
        CourseEnrollment courseEnrollment = courseEnrollmentRepository.findByCourseEnrollmentId(courseEnrollmentId).orElseThrow(()->new RuntimeException("Enrollment not found for given course and student id"));
        courseEnrollmentRepository.delete(courseEnrollment);

    }



}
