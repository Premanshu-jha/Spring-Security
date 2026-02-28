package org.example.springsecurity.Controller;

import org.example.springsecurity.Model.CourseEnrollment;
import org.example.springsecurity.Service.CourseEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enroll")
public class CourseEnrollmentController {
    @Autowired
    CourseEnrollmentService courseEnrollmentService;

    @GetMapping
    public List<CourseEnrollment> getEnrollments(){
        return courseEnrollmentService.getAllCourseEnrollments();
    }

    @PostMapping
    public void addEnrollment(@RequestParam Long studentId,@RequestParam Long courseId,@RequestBody CourseEnrollment courseEnrollment){
        courseEnrollmentService.createCourseEnrollment(studentId,courseId,courseEnrollment);
    }

    @DeleteMapping
    public void unEnrollment(@RequestParam Long studentId,@RequestParam Long courseId,@RequestBody CourseEnrollment courseEnrollment){
        courseEnrollmentService.unEnrollCourse(studentId,courseId,courseEnrollment);
    }
}
