package org.example.springsecurity.Model;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.Date;
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
    private List<Student> students;

    private OffsetDateTime createdAt;

    @PrePersist
    public void prePersist(){
        createdAt = OffsetDateTime.now();
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

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }
}
