package com.microservicios.user_microservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    private String id; // Asegúrate de que este campo esté presente
    private String name; // Nombre del usuario
    private String lastName; // Apellido del usuario
    private String role; // Rol del usuario (ej. "ESTUDIANTE", "PROFESOR")
}