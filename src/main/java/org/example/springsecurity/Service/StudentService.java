package org.example.springsecurity.Service;

import org.example.springsecurity.Model.Student;
import org.example.springsecurity.Model.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(Integer pageNumbr,Integer pageSize){
        Pageable pageReq = PageRequest.of(pageNumbr,pageSize);
        return studentRepository.findAll(pageReq).getContent();
    }
    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public void patchStudent(Long id,Student student){
        Optional<Student> originalStudent = studentRepository.findById(id);
        if(originalStudent.isPresent()){
             Student studBody = originalStudent.get();
             if(student.getFirstName() != null) studBody.setFirstName(student.getFirstName());
             if(student.getLastName() != null) studBody.setLastName(student.getLastName());
             if(student.getAge() != null) studBody.setAge(student.getAge());
             if(student.getEmail() != null) studBody.setEmail(student.getEmail());
             studentRepository.save(studBody);
        }
    }
}
