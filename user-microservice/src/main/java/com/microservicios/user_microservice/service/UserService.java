package com.microservicios.user_microservice.service;

import com.microservicios.user_microservice.entity.UserEntity;
import com.microservicios.user_microservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> getUserById(String id) {
        return userRepository.findById(id);
    }

    public UserEntity createUser (UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    public Optional<UserEntity> updateUser (UserEntity userEntity) {
        return userRepository.findById(userEntity.getId())
                .map(existingUser  -> userRepository.save(userEntity));
    }

    public void deleteUser (String id) {
        userRepository.deleteById(id);
    }

    public List<UserEntity> getUsersByRole(String role) {
        return userRepository.findAll().stream()
                .filter(user -> user.getRole().equals(role))
                .toList();
    }

    public List<UserEntity> searchUsersByName(String name, String lastName) {
        return userRepository.findAll().stream()
                .filter(user -> user.getName().equalsIgnoreCase(name) && user.getLastName().equalsIgnoreCase(lastName))
                .toList();
    }
}