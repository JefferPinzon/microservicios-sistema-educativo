package com.microservicios.user_microservice.controller;


import com.microservicios.user_microservice.entity.UserEntity;
import com.microservicios.user_microservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserEntity> getAllProducts() {
        return userRepository.findAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createProduct(@RequestBody UserEntity productEntity) {
        userRepository.save(productEntity);
    }

}
