package org.example.springsecurity.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<CourseEnrollment> courseEnrollments;

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



}
