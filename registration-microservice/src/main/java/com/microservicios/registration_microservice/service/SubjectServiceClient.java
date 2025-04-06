package com.microservicios.registration_microservice.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "subject-microservice", url = "http://localhost:8001")
public interface SubjectServiceClient {
    @GetMapping("/api/subjects/{id}")
    <SubjectEntity>
    SubjectEntity getSubjectById(@PathVariable String id);
}