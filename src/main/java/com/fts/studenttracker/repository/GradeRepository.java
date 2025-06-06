package com.fts.studenttracker.repository;

import com.fts.studenttracker.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Integer> {
    List<Grade> findByStudentId(int studentId);
    List<Grade> findBySubjectId(int subjectId);
}
