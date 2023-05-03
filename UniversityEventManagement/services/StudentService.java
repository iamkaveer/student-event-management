package com.management.UniversityEventManagement.services;

import com.management.UniversityEventManagement.exceptions.ClassNotFoundExceptions;
import com.management.UniversityEventManagement.models.Department;
import com.management.UniversityEventManagement.models.Student;
import com.management.UniversityEventManagement.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private IStudentRepository studentRepository;

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new ClassNotFoundExceptions("Student not found with id " + studentId));
    }


    public void deleteStudent(int studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ClassNotFoundExceptions("Student not found with id " + studentId));
        studentRepository.delete(student);
    }

    public Student updateStudentDepartment(int studentId, Department department) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ClassNotFoundExceptions("Student not found with id " + studentId));
        student.setDepartment(department);
        return studentRepository.save(student);
    }
}
