package com.microservicios.registration_microservice.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-microservice", url = "http://localhost:8002")
public interface UserServiceClient {
    @GetMapping("/api/users/{id}")
    <UserEntity>
    UserEntity getUserById(@PathVariable String id);
}