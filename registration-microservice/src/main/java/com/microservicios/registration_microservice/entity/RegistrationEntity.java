package com.microservicios.registration_microservice.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "registration")
@Getter
@Setter
@NoArgsConstructor
public class RegistrationEntity {
    @Id
    private String id;
    private String studentId; // Relación con user.userRole = "ESTUDIANTE"
    private String subjectId; // Relación con subject.id
    private String status; // "ACTIVE", "CANCELLED", "COMPLETED"
}
