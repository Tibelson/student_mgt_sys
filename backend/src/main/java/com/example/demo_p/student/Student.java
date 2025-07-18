package com.example.demo_p.student;
import jakarta.persistence.Table;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"

    )
    private Long id;
    private String name;
    @Transient
    private Integer age;
    @Column(unique = true)
    private String email;
    private  LocalDate dob;

    public Student() {
    }


    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
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

    public Integer getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setDob(LocalDate dob){
        this.dob = dob;
    }
    public LocalDate getDob(){
        return dob;
    }

    @Override
    public String  toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", dob='" + dob  +
                '}';
    }
}
