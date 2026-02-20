package org.example.springsecurity.Controller;

import org.example.springsecurity.Model.StudentIdCard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentIdCardController {

    @GetMapping("/student-id-card")
    public List<StudentIdCard> getAllIdCards(){

    }
}
