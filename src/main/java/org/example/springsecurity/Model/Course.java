package org.example.springsecurity.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(
            columnDefinition = "TEXT",
            nullable = false,
            unique = true
    )
    private String name;

    @Column(
            columnDefinition = "TEXT",
            nullable = false
    )
    private String department;


    @ManyToMany(
            mappedBy = "courses",
            fetch = FetchType.LAZY
    )
    @JsonIgnore
    private List<Student> students;

    private ZonedDateTime createdAt;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
