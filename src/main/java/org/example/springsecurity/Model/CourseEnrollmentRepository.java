package org.example.springsecurity.Model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseEnrollmentRepository extends JpaRepository<CourseEnrollment,CourseEnrollmentId> {

    Optional<CourseEnrollment> findByCourseEnrollmentId(CourseEnrollmentId courseEnrollmentId);
}
