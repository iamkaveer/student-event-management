package com.management.UniversityEventManagement.repository;

import com.management.UniversityEventManagement.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student,Integer> {
}
