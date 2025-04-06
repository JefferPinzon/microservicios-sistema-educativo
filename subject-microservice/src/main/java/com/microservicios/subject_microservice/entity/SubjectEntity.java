package com.microservicios.subject_microservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "subject")
@Getter
@Setter
@NoArgsConstructor

public class SubjectEntity {
    @Id
    private String id;
    private String subjectName;
    private String subjectCode;
    private String teacherId;
}
