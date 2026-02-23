package org.example.springsecurity.Controller;

import org.example.springsecurity.Model.StudentIdCard;
import org.example.springsecurity.Service.StudentIdCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentIdCardController {

    @Autowired
    StudentIdCardService studentIdCardService;

    @GetMapping("/student/{studentId}/student-id-card")
    public StudentIdCard getStudentIdCard(@PathVariable Long studentId){
         return studentIdCardService.getStudentIdCard(studentId);
    }

    @PostMapping("/student/{studentId}/student-id-card")
    public void addStudentIdCard(@PathVariable Long studentId,@RequestBody StudentIdCard idCard){
        studentIdCardService.addIdCard(studentId,idCard);
    }

    @PatchMapping("/student-id-card/{id}")
    public void patchStudentIdCard(@PathVariable Long id,@RequestBody StudentIdCard idCard){
        studentIdCardService.updateIdCard(id,idCard);
    }
}
