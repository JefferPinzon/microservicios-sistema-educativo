package com.microservicios.subject_microservice.controller;

import com.microservicios.subject_microservice.entity.SubjectEntity;
import com.microservicios.subject_microservice.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping
    public ResponseEntity<List<SubjectEntity>> getAllSubjects() {
        List<SubjectEntity> subjects = subjectService.getAllSubjects();
        return subjects.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(subjects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubjectEntity> getSubjectById(@PathVariable String id) {
        SubjectEntity subject = subjectService.getSubjectById(id);
        return subject == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(subject);
    }

    @PostMapping
    public ResponseEntity<SubjectEntity> createSubject(@RequestBody SubjectEntity subject) {
        return ResponseEntity.ok(subjectService.createSubject(subject));
    }

    @PutMapping
    public ResponseEntity<SubjectEntity> updateSubject(@RequestBody SubjectEntity subject) {
        SubjectEntity updatedSubject = subjectService.updateSubject(subject);
        return updatedSubject == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updatedSubject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubject(@PathVariable String id) {
        subjectService.deleteSubject(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<List<SubjectEntity>> getSubjectsByTeacher(@PathVariable String teacherId) {
        List<SubjectEntity> subjects = subjectService.getSubjectsByTeacherId(teacherId);
        return subjects.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(subjects);
    }

    @GetMapping("/code/{subjectCode}")
    public ResponseEntity<List<SubjectEntity>> getSubjectsByCode(@PathVariable String subjectCode) {
        List<SubjectEntity> subjects = subjectService.getSubjectsBySubjectCode(subjectCode);
        return subjects.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(subjects);
    }
}