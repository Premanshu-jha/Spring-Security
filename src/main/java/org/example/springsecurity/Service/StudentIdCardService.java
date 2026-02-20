package org.example.springsecurity.Service;

import org.example.springsecurity.Model.Student;
import org.example.springsecurity.Model.StudentIdCard;
import org.example.springsecurity.Model.StudentIdCardRepository;
import org.example.springsecurity.Model.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class StudentIdCardService {
    @Autowired
    StudentIdCardRepository studentIdCardRepository;

    @Autowired
    StudentRepository studentRepository;

    public List<StudentIdCard> getAllIdCards(){
         return studentIdCardRepository.findAll();
    }

    public StudentIdCard getIdCardsByStudentId(Long id){
        Student student = studentRepository.findById(id).orElseThrow(()->new RuntimeException("Student not found"));
        Optional<StudentIdCard> idCard = studentIdCardRepository.findById(student.getId());
        if(idCard.isPresent()) return idCard.get();
        else throw new RuntimeException("Id card not found for the student");
    }
}
