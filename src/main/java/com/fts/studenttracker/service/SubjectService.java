package com.fts.studenttracker.service;

import com.fts.studenttracker.entity.Subject;
import com.fts.studenttracker.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Optional<Subject> getSubjectById(int id) {
        return subjectRepository.findById(id);
    }

    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Optional<Subject> updateSubject(int id, Subject updatedSubject) {
        return subjectRepository.findById(id).map(subject -> {
            subject.setName(updatedSubject.getName());
            return subjectRepository.save(subject);
        });
    }

    public void deleteSubject(int id) {
        subjectRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return subjectRepository.existsById(id);
    }
}
