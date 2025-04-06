package com.microservicios.registration_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RegistrationMicroserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(RegistrationMicroserviceApplication.class, args);
	}
}