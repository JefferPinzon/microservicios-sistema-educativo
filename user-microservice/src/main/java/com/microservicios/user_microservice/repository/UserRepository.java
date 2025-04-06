package com.microservicios.user_microservice.repository;

import com.microservicios.user_microservice.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<UserEntity, String> {

    List<UserEntity> findByRole(String role); // Método para buscar por rol

    List<UserEntity> findByNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String name, String lastName); // Método para buscar por nombre o apellido
}