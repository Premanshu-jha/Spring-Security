package org.example.springsecurity.Controller;

import org.example.springsecurity.Model.Student;
import org.example.springsecurity.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseEntity<?> getAllStudents(@RequestParam(required = false) Integer pageNumber,@RequestParam(required = false) Integer pageSize){
        if(pageNumber == null || pageSize == null) return ResponseEntity.badRequest().body(Map.of("error","pageNumber or pageSize is missing"));
       return ResponseEntity.ok().body(studentService.getAllStudents(pageNumber,pageSize));
    }

    @PostMapping
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @PatchMapping("/{id}")
    public void patchStudent(@PathVariable Long id,@RequestBody Student student){
        studentService.patchStudent(id,student);
    }


}
