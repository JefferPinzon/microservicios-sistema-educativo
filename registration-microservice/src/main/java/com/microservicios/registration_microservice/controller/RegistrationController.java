package com.microservicios.registration_microservice.controller;


import com.microservicios.registration_microservice.entity.RegistrationEntity;
import com.microservicios.registration_microservice.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registrations")
public class RegistrationController {
    @Autowired
    private RegistrationRepository registrationRepository;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RegistrationEntity> getAllProducts() {
        return registrationRepository.findAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createProduct(@RequestBody RegistrationEntity productEntity) {
        registrationRepository.save(productEntity);
    }

}
