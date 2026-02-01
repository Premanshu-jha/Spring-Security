package org.example.springsecurity.Controller;

import org.example.springsecurity.Model.Student;
import org.example.springsecurity.Model.StudentRepository;
import org.example.springsecurity.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents(){
       return studentService.getAllStudents();
    }

    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody Student student){
        return (student.getName().isBlank() || student.getName() == null)?
            ResponseEntity.badRequest().body("Student name is required")
         :new ResponseEntity<>(studentService.addStudent(student), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Integer id,@RequestBody Student student){
        Optional<Student> response = studentService.updateStudent(id,student);
        return response.isPresent()?new ResponseEntity<>(response.get(),HttpStatus.OK):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with id "+id+" not found");
    }

}
