package org.example.springsecurity.Controller;

import org.example.springsecurity.Model.Course;
import org.example.springsecurity.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping("/student/{studentId}/courses")
    public List<Course> getCourses(@PathVariable Long studentId){
        return courseService.getCourses(studentId);
    }

    @PostMapping("/student/{studentId}/course")
    public void postCourse(@PathVariable Long studentId, @RequestBody Course course){
        courseService.addCourse(studentId,course);
    }

    @PatchMapping("/course/{id}")
    public void patchCourse(@PathVariable Long id,@RequestBody Course courseReq){
         courseService.updateCourse(id,courseReq);
    }
}
