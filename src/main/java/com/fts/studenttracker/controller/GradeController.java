package com.fts.studenttracker.controller;

import com.fts.studenttracker.entity.Grade;
import com.fts.studenttracker.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
public class GradeController {

    private final GradeService gradeService;

    @Autowired
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @GetMapping
    public ResponseEntity<List<Grade>> getAllGrades() {
        return ResponseEntity.ok(gradeService.getAllGrades());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Grade> getGradeById(@PathVariable int id) {
        return gradeService.getGradeById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Grade> addGrade(@RequestBody Grade grade) {
        return ResponseEntity.ok(gradeService.saveGrade(grade));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Grade> updateGrade(@PathVariable int id, @RequestBody Grade updatedGrade) {
        return gradeService.updateGrade(id, updatedGrade)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrade(@PathVariable int id) {
        if (!gradeService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        gradeService.deleteGrade(id);
        return ResponseEntity.noContent().build();
    }
}
