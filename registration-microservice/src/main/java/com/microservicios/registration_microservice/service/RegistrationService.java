package com.microservicios.registration_microservice.service;

import com.microservicios.registration_microservice.entity.RegistrationEntity;
import com.microservicios.registration_microservice.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {
    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private UserServiceClient userServiceClient;

    @Autowired
    private SubjectServiceClient subjectServiceClient;

    public RegistrationEntity createRegistration(RegistrationEntity registration) {
        // Validar que el estudiante y la asignatura existan
        ResponseEntity<?> userResponse = userServiceClient.getUserById(registration.getStudentId());
        ResponseEntity<?> subjectResponse = subjectServiceClient.getSubjectById(registration.getSubjectId());

        if (userResponse.getStatusCode() == HttpStatus.OK && subjectResponse.getStatusCode() == HttpStatus.OK) {
            return registrationRepository.save(registration);
        } else {
            throw new RuntimeException("Estudiante o asignatura no encontrados");
        }
    }

    public List<RegistrationEntity> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    public List<RegistrationEntity> getRegistrationsByStudent(String studentId) {
        return registrationRepository.findByStudentId(studentId);
    }

    public List<RegistrationEntity> getRegistrationsBySubject(String subjectId) {
        return registrationRepository.findBySubjectId(subjectId);
    }

    public void deleteRegistration(String registrationId) {
        registrationRepository.deleteById(registrationId);
    }
}