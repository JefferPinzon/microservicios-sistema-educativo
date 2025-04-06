package com.microservicios.subject_microservice.service;

import com.microservicios.subject_microservice.entity.SubjectEntity;
import com.microservicios.subject_microservice.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;

    public List<SubjectEntity> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public SubjectEntity getSubjectById(String id) {
        return subjectRepository.findById(id).orElse(null);
    }

    public SubjectEntity createSubject(SubjectEntity subject) {
        return subjectRepository.save(subject);
    }

    public SubjectEntity updateSubject(SubjectEntity subject) {
        if (subjectRepository.existsById(subject.getId())) {
            return subjectRepository.save(subject);
        }
        return null;
    }

    public void deleteSubject(String id) {
        subjectRepository.deleteById(id);
    }

    public List<SubjectEntity> getSubjectsByTeacherId(String teacherId) {
        return subjectRepository.findByTeacherId(teacherId);
    }

    public List<SubjectEntity> getSubjectsBySubjectCode(String subjectCode) {
        return subjectRepository.findBySubjectCode(subjectCode);
    }
}