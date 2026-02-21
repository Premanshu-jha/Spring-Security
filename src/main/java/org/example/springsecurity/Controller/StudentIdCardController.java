package org.example.springsecurity.Controller;

import org.example.springsecurity.Model.StudentIdCard;
import org.example.springsecurity.Service.StudentIdCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/{studentId}/student-id-card")
public class StudentIdCardController {

    @Autowired
    StudentIdCardService studentIdCardService;

    @GetMapping
    public StudentIdCard getStudentIdCard(@PathVariable Long studentId){
         return studentIdCardService.getStudentIdCard(studentId);
    }

    @PostMapping
    public void addStudentIdCard(@PathVariable Long studentId,@RequestBody StudentIdCard idCard){
        studentIdCardService.addIdCard(studentId,idCard);
    }

    @PatchMapping("/{id}")
    public void patchStudentIdCard(@PathVariable Long studentId,@PathVariable Long id,@RequestBody StudentIdCard idCard){
        studentIdCardService.updateIdCard(studentId,id,idCard);
    }
}
