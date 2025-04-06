package com.microservicios.user_microservice.service;

import com.microservicios.user_microservice.entity.UserEntity;
import com.microservicios.user_microservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> getUserById(String id) {
        return userRepository.findById(id);
    }

    public UserEntity createUser (UserEntity user) {
        return userRepository.save(user);
    }

    public Optional<UserEntity> updateUser (UserEntity user) {
        if (userRepository.existsById(user.getId())) {
            return Optional.of(userRepository.save(user));
        }
        return Optional.empty();
    }

    public void deleteUser (String id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
    }

    public List<UserEntity> getUsersByRole(String role) {
        return userRepository.findByRole(role);
    }

    public List<UserEntity> searchUsersByName(String name, String lastName) {
        return userRepository.findByNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(name, lastName);
    }
}