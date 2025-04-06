package com.microservicios.user_microservice.controller;

import com.microservicios.user_microservice.entity.UserEntity;
import com.microservicios.user_microservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> users = userService.getAllUsers();
        return users.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable String id) {
        Optional<UserEntity> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UserEntity> createUser (@RequestBody UserEntity userEntity) {
        UserEntity createdUser  = userService.createUser (userEntity);
        return ResponseEntity.status(201).body(createdUser );
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateUser (@PathVariable String id, @RequestBody UserEntity userEntity) {
        userEntity.setId(id);
        Optional<UserEntity> updatedUser  = userService.updateUser (userEntity);
        return updatedUser .map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser (@PathVariable String id) {
        userService.deleteUser (id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<List<UserEntity>> getUsersByRole(@PathVariable String role) {
        List<UserEntity> users = userService.getUsersByRole(role);
        return users.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(users);
    }

    @GetMapping("/search")
    public ResponseEntity<List<UserEntity>> searchUsersByName(
            @RequestParam String name,
            @RequestParam String lastName) {
        List<UserEntity> users = userService.searchUsersByName(name, lastName);
        return users.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(users);
    }
}