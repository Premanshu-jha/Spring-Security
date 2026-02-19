package org.example.springsecurity;

import com.github.javafaker.Faker;
import org.example.springsecurity.Model.Student;
import org.example.springsecurity.Model.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootApplication
public class SpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Faker faker = new Faker();
            for(int i=0;i<2;i++){
                 String firstName = faker.name().firstName();
                 String lastName = faker.name().lastName();
                 String email = """
                         %s.%s@amigoscode.com
                         """.formatted(firstName,lastName);
                Student student = new Student(firstName,lastName,faker.number().numberBetween(17,55),
                                        email);
                studentRepository.save(student);
            }
            Sort sort = Sort.by("firstName").descending().and(Sort.by("age").descending());
            studentRepository.findAll(sort).forEach(s->{
                System.out.println(s.getFirstName()+ " " + s.getAge());
            });
            Pageable pageable = PageRequest.of(0,10);
            Page<Student> page = studentRepository.findAll(pageable);
            System.out.println("Page "+page);
            System.out.println(studentRepository.count());
            System.out.println(page.get());
        };
    }



}
