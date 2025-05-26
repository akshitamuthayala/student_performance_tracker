package com.fts.studenttracker.repository;

import com.fts.studenttracker.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByYear(String year);
    List<Student> findBySection(String section);
}
