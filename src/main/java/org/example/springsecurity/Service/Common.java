package org.example.springsecurity.Service;

import org.example.springsecurity.Model.Student;
import org.example.springsecurity.Model.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class Common {

    @Autowired
    StudentRepository studentRepository;

    public Student getStudent(Long studentId){
        return studentRepository.findById(studentId).orElseThrow(()->new RuntimeException("Student not found"));
    }
}
