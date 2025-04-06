package com.microservicios.user_microservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.microservicios.user_microservice.entity.UserEntity;

public interface UserRepository extends MongoRepository<UserEntity, String> {
}