package com.microservicios.subject_microservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "subject")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectEntity {
    @Id
    private String id;
    private String subjectName;
    private String subjectCode;
    private String teacherId;
}