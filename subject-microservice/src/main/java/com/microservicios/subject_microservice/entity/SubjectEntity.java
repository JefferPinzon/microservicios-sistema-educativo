package com.microservicios.subject_microservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "subjects") // Cambié "subject" a "subjects" para mantener la consistencia
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectEntity {
    @Id
    private String id;
    private String subjectName; // Nombre de la asignatura
    private String subjectCode; // Código de la asignatura
    private String teacherId; // ID del profesor que imparte la asignatura
}