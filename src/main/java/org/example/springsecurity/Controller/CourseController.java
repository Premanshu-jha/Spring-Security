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

    @GetMapping("/courses")
    public List<Course> getCourses(){
        return courseService.getCourses();
    }

    @PostMapping("/course")
    public void postCourse(@RequestBody Course course){
        courseService.addCourse(course);
    }

    @PatchMapping("/course/{id}")
    public void patchCourse(@PathVariable Long id,@RequestBody Course courseReq){
         courseService.updateCourse(id,courseReq);
    }
}
