package org.example.springsecurity.Model;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

@Entity
public class StudentIdCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(
      nullable = false,
      columnDefinition = "TEXT",
      unique = true
    )
    private String cardNumber;

    @Column(
       nullable = false
    )
    private OffsetDateTime createdAt;

    @OneToOne
    @JoinColumn(
       name = "student_id",
       referencedColumnName = "id",
       foreignKey = @ForeignKey(name = "student_id_card_student_id_foreign_key"),
       nullable = false,
       unique = true
    )
    private Student student;

    public StudentIdCard() {
    }
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

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }


}
