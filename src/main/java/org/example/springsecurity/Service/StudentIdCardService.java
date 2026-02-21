package org.example.springsecurity.Service;

import org.example.springsecurity.Model.Student;
import org.example.springsecurity.Model.StudentIdCard;
import org.example.springsecurity.Model.StudentIdCardRepository;
import org.example.springsecurity.Model.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentIdCardService {
    @Autowired
    StudentIdCardRepository studentIdCardRepository;

    @Autowired
    StudentRepository studentRepository;

    public Student getStudent(Long studentId){
        return studentRepository.findById(studentId).orElseThrow(()->new RuntimeException("Student not found"));
    }
    public StudentIdCard getStudentIdCard(Long id){
       return studentIdCardRepository.findByStudentId(id).orElseThrow(()->new RuntimeException("Id card not found for the student"));
    }
    public StudentIdCard getIdCardsByStudentId(Long studentId){
        Student student = getStudent(studentId);
        StudentIdCard idCard = getStudentIdCard(student.getId());
        return idCard;
    }

    public void addIdCard(Long studentId,StudentIdCard idCard){
         Student student = getStudent(studentId);
         idCard.setStudent(student);
         studentIdCardRepository.save(idCard);
    }

    public void updateIdCard(Long studentId,Long id,StudentIdCard idCard){
        Student student = getStudent(studentId);
        StudentIdCard studentIdCard = getStudentIdCard(student.getId());
        if(idCard.getCardNumber() != null) studentIdCard.setCardNumber(idCard.getCardNumber());
        studentIdCardRepository.save(studentIdCard);
    }
}
