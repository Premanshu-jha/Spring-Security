package org.example.springsecurity.Service;

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

    public CourseEnrollment createCourseEnrollment(Long studentId,Long courseId,CourseEnrollment courseEnrollment){
        Student student = getStudent(studentId);
        Course course = getCourse(courseId);
        CourseEnrollmentId courseEnrollmentId = new CourseEnrollmentId(student.getId(),course.getId());
        courseEnrollment.setCourseEnrollmentId(courseEnrollmentId);
        return courseEnrollment;
    }

    public void addCourseEnrollment(Long studentId,Long courseId,CourseEnrollment courseEnrollment){
        courseEnrollmentRepository.save(createCourseEnrollment(studentId,courseId,courseEnrollment));
    }

    public void unEnrollCourse(Long studentId,Long courseId,CourseEnrollment courseEnrollment){
        courseEnrollmentRepository.delete(createCourseEnrollment(studentId,courseId,courseEnrollment));
    }



}
