
package com.example.studentmanagement.controller;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.service.StudentService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // POST - Add a student
    @PostMapping
    public ResponseEntity<Student> addStudent(
            @Valid @RequestBody Student student) {

        Student saved = service.addStudent(student);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(saved);
    }

    // GET - Get all students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {

        return ResponseEntity.ok(service.getAllStudents());
    }

    // GET - Get student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.getStudentById(id));
    }

    // PUT - Update student
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody Student student) {

        return ResponseEntity.ok(
                service.updateStudent(id, student));
    }

    // DELETE - Delete student
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(
            @PathVariable Long id) {

        service.deleteStudent(id);

        return ResponseEntity.noContent().build();
    }

    // GET - Get students by course
    @GetMapping("/course/{course}")
    public ResponseEntity<List<Student>> getStudentsByCourse(
            @PathVariable String course) {

        return ResponseEntity.ok(
                service.getStudentsByCourse(course));
    }
}
