package com.microservicios.user_microservice.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "user")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {
    @Id
    private String id;
    private String userName;
    private String userLastName;
    private String userRole;

}
