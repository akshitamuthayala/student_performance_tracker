package com.fts.studenttracker.service;

import com.fts.studenttracker.entity.Grade;
import com.fts.studenttracker.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {

    private final GradeRepository gradeRepository;

    @Autowired
    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    public Optional<Grade> getGradeById(int id) {
        return gradeRepository.findById(id);
    }

    public Grade saveGrade(Grade grade) {
        return gradeRepository.save(grade);
    }

    public Optional<Grade> updateGrade(int id, Grade updatedGrade) {
        return gradeRepository.findById(id).map(existingGrade -> {
            existingGrade.setMarks(updatedGrade.getMarks());
            existingGrade.setStudent(updatedGrade.getStudent());
            existingGrade.setSubject(updatedGrade.getSubject());
            return gradeRepository.save(existingGrade);
        });
    }

    public boolean existsById(int id) {
        return gradeRepository.existsById(id);
    }

    public void deleteGrade(int id) {
        gradeRepository.deleteById(id);
    }
}
