package com.microservicios.registration_microservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.microservicios.registration_microservice.entity.RegistrationEntity;

public interface RegistrationRepository extends MongoRepository<RegistrationEntity, String> {
}
