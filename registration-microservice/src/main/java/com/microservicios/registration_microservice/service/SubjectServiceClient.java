package com.microservicios.registration_microservice.service;

import com.microservicios.subject_microservice.entity.SubjectEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "subject-microservice", url = "http://localhost:8002")
public interface SubjectServiceClient {
    @GetMapping("/api/subjects/{id}")
    SubjectEntity getSubjectById(@PathVariable String id);
}