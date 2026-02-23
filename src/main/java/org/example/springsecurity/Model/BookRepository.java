package org.example.springsecurity.Model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Long> {

    Optional<List<Book>> findAllByStudentId(Long studentId);
}
