package com.management.UniversityEventManagement.controllers;

import com.management.UniversityEventManagement.exceptions.ClassNotFoundExceptions;
import com.management.UniversityEventManagement.models.Department;
import com.management.UniversityEventManagement.models.Student;
import com.management.UniversityEventManagement.repository.IStudentRepository;
import com.management.UniversityEventManagement.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private IStudentRepository iStudentRepository;

    //create a new student
    @PostMapping("/students/create")
    public Student addStudent(@RequestBody @Valid Student student) {
        return studentService.addStudent(student);
    }

    //update student by id
    @PutMapping("/update-student/{studentId}")
    public ResponseEntity<Student> updateStudentDepartment(@PathVariable int studentId, @RequestParam Department department) {
        Student student = iStudentRepository.findById(studentId)
                .orElseThrow(() -> new ClassNotFoundExceptions("Student not found with id " + studentId));
        student.setDepartment(department);
        return ResponseEntity.ok(studentService.addStudent(student));
    }

    //delete student by id
    @DeleteMapping("/delete-student/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int studentId) {
        Student student = iStudentRepository.findById(studentId)
                .orElseThrow(() -> new ClassNotFoundExceptions("Student not found with id " + studentId));
        studentService.deleteStudent(studentId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get-all-students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/get-student-by-id/{studentId}")
    public Student getStudentById(@PathVariable int studentId) {
        return iStudentRepository.findById(studentId)
                .orElseThrow(() -> new ClassNotFoundExceptions("Student not found with id " + studentId));
    }
}
