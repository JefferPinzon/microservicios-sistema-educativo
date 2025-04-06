package com.microservicios.subject_microservice.controller;


import com.microservicios.subject_microservice.entity.SubjectEntity;
import com.microservicios.subject_microservice.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {
    @Autowired
    private SubjectRepository subjectRepository;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SubjectEntity> getAllProducts() {
        return subjectRepository.findAll();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createProduct(@RequestBody SubjectEntity productEntity) {
        subjectRepository.save(productEntity);
    }

}
