package org.example.springsecurity.Service;

import org.example.springsecurity.Model.Student;
import org.example.springsecurity.Model.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){
         return studentRepository.findAll();
    }

    public Student addStudent(Student student){
         return studentRepository.save(student);
    }

    public Optional<Student> updateStudent(Integer id,Student student){
         return studentRepository.findById(id).map(studObj ->{
             if(student.getName() != null) studObj.setName(student.getName());
             if(student.getMarks() != null) studObj.setMarks(student.getMarks());

             return studentRepository.save(studObj);
         });
    }
}
