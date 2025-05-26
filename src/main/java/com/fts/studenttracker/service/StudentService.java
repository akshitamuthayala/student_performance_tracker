package com.fts.studenttracker.service;

import com.fts.studenttracker.entity.Student;
import com.fts.studenttracker.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(int id) {
        return studentRepository.findById(id);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Optional<Student> updateStudent(int id, Student updatedStudent) {
        return studentRepository.findById(id).map(student -> {
            student.setName(updatedStudent.getName());
            student.setRollNumber(updatedStudent.getRollNumber());
            student.setYear(updatedStudent.getYear());
            student.setSection(updatedStudent.getSection());
            student.setGrade(updatedStudent.getGrade());
            return studentRepository.save(student);
        });
    }

    public boolean existsById(int id) {
        return studentRepository.existsById(id);
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}
