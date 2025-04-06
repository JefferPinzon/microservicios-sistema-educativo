package com.microservicios.registration_microservice.controller;

import com.microservicios.registration_microservice.entity.RegistrationEntity;
import com.microservicios.registration_microservice.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registrations")
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<RegistrationEntity> createRegistration(@RequestBody RegistrationEntity registration) {
        return ResponseEntity.ok(registrationService.createRegistration(registration));
    }

    @GetMapping
    public ResponseEntity<List<RegistrationEntity>> getAllRegistrations() {
        return ResponseEntity.ok(registrationService.getAllRegistrations());
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<RegistrationEntity>> getRegistrationsByStudent(@PathVariable String studentId) {
        return ResponseEntity.ok(registrationService.getRegistrationsByStudent(studentId));
    }

    @GetMapping("/subject/{subjectId}")
    public ResponseEntity<List<RegistrationEntity>> getRegistrationsBySubject(@PathVariable String subjectId) {
        return ResponseEntity.ok(registrationService.getRegistrationsBySubject(subjectId));
    }

    @DeleteMapping("/{registrationId}")
    public ResponseEntity<Void> deleteRegistration(@PathVariable String registrationId) {
        registrationService.deleteRegistration(registrationId);
        return ResponseEntity.noContent().build();
    }
}