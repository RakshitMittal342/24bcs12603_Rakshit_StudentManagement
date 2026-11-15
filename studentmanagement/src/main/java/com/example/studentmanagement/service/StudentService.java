
package com.example.studentmanagement.service;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.repository.StudentRepository;
import com.example.studentmanagement.exception.StudentNotFoundException;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    // Add student
    public Student addStudent(Student student) {
        return repository.save(student);
    }

    // Get all students
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // Get student by ID
    public Student getStudentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                    new StudentNotFoundException(id));
    }

    // Update student
    public Student updateStudent(Long id, Student updatedStudent) {

        Student student = getStudentById(id);

        student.setName(updatedStudent.getName());
        student.setEmail(updatedStudent.getEmail());
        student.setCourse(updatedStudent.getCourse());
        student.setAge(updatedStudent.getAge());

        return repository.save(student);
    }

    // Delete student
    public void deleteStudent(Long id) {

        Student student = getStudentById(id);

        repository.delete(student);
    }

    // Get students by course
    public List<Student> getStudentsByCourse(String course) {

        return repository.findByCourseIgnoreCase(course);
    }
}
