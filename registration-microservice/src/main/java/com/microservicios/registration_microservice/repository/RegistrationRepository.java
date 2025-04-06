package com.microservicios.registration_microservice.repository;

import com.microservicios.registration_microservice.entity.RegistrationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistrationRepository extends MongoRepository<RegistrationEntity, String> {
    List<RegistrationEntity> findByStudentId(String studentId);
    List<RegistrationEntity> findBySubjectId(String subjectId);
}