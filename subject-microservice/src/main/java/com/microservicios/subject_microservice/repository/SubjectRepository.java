package com.microservicios.subject_microservice.repository;

import com.microservicios.subject_microservice.entity.SubjectEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubjectRepository extends MongoRepository<SubjectEntity, String> {
}
