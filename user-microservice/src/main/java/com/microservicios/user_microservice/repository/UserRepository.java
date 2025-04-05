package com.microservicios.user_microservice.repository;

import com.microservicios.user_microservice.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntity, String> {
}
