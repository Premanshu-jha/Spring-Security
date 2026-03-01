package org.example.springsecurity.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.ZonedDateTime;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookName;

    private ZonedDateTime createdAt;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
         name = "student_id",
         referencedColumnName = "id"
    )
    @JsonIgnore
    private Student student;

    @PrePersist
    public void prePersist(){
        createdAt = ZonedDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
