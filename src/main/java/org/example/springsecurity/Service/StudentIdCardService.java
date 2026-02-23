package org.example.springsecurity.Service;

import org.example.springsecurity.Model.Student;
import org.example.springsecurity.Model.StudentIdCard;
import org.example.springsecurity.Model.StudentIdCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentIdCardService extends Common{
    @Autowired
    StudentIdCardRepository studentIdCardRepository;

    public StudentIdCard getStudentIdCardById(Long id){
       return studentIdCardRepository.findById(id).orElseThrow(()->new RuntimeException("Id card not found for the student"));
    }
    public StudentIdCard getStudentIdCard(Long studentId){
        return studentIdCardRepository.findByStudentId(studentId).orElseThrow(()->new RuntimeException("Id card not found for the student"));
    }


    public void addIdCard(Long studentId,StudentIdCard idCard){
         Student student = getStudent(studentId);
         idCard.setStudent(student);
         studentIdCardRepository.save(idCard);
    }

    public void updateIdCard(Long id,StudentIdCard idCard){
        StudentIdCard studentIdCard = getStudentIdCardById(id);
        if(idCard.getCardNumber() != null) studentIdCard.setCardNumber(idCard.getCardNumber());
        studentIdCardRepository.save(studentIdCard);
    }
}
