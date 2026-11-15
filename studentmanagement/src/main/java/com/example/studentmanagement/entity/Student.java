
package com.example.studentmanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Email(message = "Enter a valid email")
    @NotBlank(message = "Email cannot be empty")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Course cannot be empty")
    private String course;

    @Min(value = 1, message = "Age must be positive")
    private int age;

    public Student() {
    }

    public Student(String name, String email,
                   String course, int age) {
        this.name = name;
        this.email = email;
        this.course = course;
        this.age = age;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
