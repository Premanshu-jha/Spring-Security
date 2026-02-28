package org.example.springsecurity.Model;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

@Entity
public class CourseEnrollment {
    @EmbeddedId
    private CourseEnrollmentId courseEnrollmentId;

    @ManyToOne
    @JoinColumn(
            name = "student_id",
            foreignKey = @ForeignKey(name = "enrollment_student_id_fk")
    )
    @MapsId("studentId")
    private Student student;


    @ManyToOne
    @JoinColumn(
            name = "course_id",
            foreignKey = @ForeignKey(name = "enrollment_course_id_fk")
    )
    @MapsId("courseId")
    private Course course;

    private ZonedDateTime createdAt;

    @PrePersist
    public void prePersist(){
        createdAt = ZonedDateTime.now();
    }

    public CourseEnrollmentId getCourseEnrollmentId() {
        return courseEnrollmentId;
    }

    public void setCourseEnrollmentId(CourseEnrollmentId courseEnrollmentId) {
        this.courseEnrollmentId = courseEnrollmentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }




}
