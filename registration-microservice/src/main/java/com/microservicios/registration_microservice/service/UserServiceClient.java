package com.microservicios.registration_microservice.service;

import com.microservicios.user_microservice.entity.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-microservice")
public interface UserServiceClient {
    @GetMapping("/api/users/{id}")
    UserEntity getUserById(@PathVariable String id);
}