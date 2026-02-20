package org.example.springsecurity.Model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentIdCardRepository extends JpaRepository<StudentIdCard,Long> {

    Optional<StudentIdCard> findByStudentId(Long studentId);
}
