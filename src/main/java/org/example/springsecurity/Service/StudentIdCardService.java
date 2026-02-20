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

    public StudentIdCard getIdCardsByStudentId(Long studentId){
        Student student = studentRepository.findById(studentId).orElseThrow(()->new RuntimeException("Student not found"));
        StudentIdCard idCard = studentIdCardRepository.findByStudentId(student.getId()).orElseThrow(()->new RuntimeException("Id card not found for the student"));
        return idCard;
    }

    public void addIdCard(Long studentId,StudentIdCard idCard){
         Student student = studentRepository.findById(studentId).orElseThrow(()->new RuntimeException("Student not found"));
         idCard.setStudent(student);
         studentIdCardRepository.save(idCard);
    }

    public void updateIdCard(Long studentId,Long id,StudentIdCard idCard){
        Student student = studentRepository.findById(studentId).orElseThrow(()->new RuntimeException("Student not found"));
        StudentIdCard studentIdCard = studentIdCardRepository.findByStudentId(student.getId()).orElseThrow(()->new RuntimeException("Id card not found for the student"));
        if(idCard.getCardNumber() != null) studentIdCard.setCardNumber(idCard.getCardNumber());
        studentIdCardRepository.save(studentIdCard);
    }
}
