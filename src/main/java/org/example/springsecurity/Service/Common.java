package org.example.springsecurity.Service;

import org.example.springsecurity.Model.Course;
import org.example.springsecurity.Model.CourseRepository;
import org.example.springsecurity.Model.Student;
import org.example.springsecurity.Model.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class Common {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    public Student getStudent(Long studentId){
        return studentRepository.findById(studentId).orElseThrow(()->new RuntimeException("Student not found"));
    }

    public Course getCourse(Long id){
        return courseRepository.findById(id).orElseThrow(()->new RuntimeException("No course with the given id exist"));
    }
}
