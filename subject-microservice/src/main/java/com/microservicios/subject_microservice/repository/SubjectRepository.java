package com.microservicios.subject_microservice.repository;

import com.microservicios.subject_microservice.entity.SubjectEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends MongoRepository<SubjectEntity, String> {
    List<SubjectEntity> findByTeacherId(String teacherId);
    List<SubjectEntity> findBySubjectCode(String subjectCode);
}