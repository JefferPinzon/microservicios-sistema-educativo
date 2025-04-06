package com.microservicios.registration_microservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "registrations")
@Getter
@Setter
@NoArgsConstructor
public class RegistrationEntity {
    @Id
    private String id;
    private String studentId; // ID del estudiante
    private String subjectId; // ID de la materia
    private String status; // "ACTIVE", "CANCELLED", "COMPLETED"
}