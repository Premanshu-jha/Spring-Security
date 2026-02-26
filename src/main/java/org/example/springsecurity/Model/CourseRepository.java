package org.example.springsecurity.Model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course,Long> {

    List<Course> findAllByStudents_Id(Long id);

    Optional<Course> findByName(String name);
}
