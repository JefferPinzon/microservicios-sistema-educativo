@ -0,0 +1,141 @@
# Microservicio de Usuarios
Este proyecto es un microservicio de gestión de usuarios desarrollado con Spring Boot y MongoDB. Proporciona una API RESTful para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre entidades de usuario.

## Características

- Gestión completa de usuarios (crear, consultar, actualizar, eliminar)
- Búsqueda de usuarios por rol
- Búsqueda de usuarios por nombre y apellido
- Persistencia de datos en MongoDB
- API RESTful con respuestas HTTP apropiadas

## Requisitos Previos

- Java 17
- MongoDB
- Maven

## Configuración

La aplicación está configurada con los siguientes parámetros en application.properties:
```bash
propertiesCopiarspring.application.name=user-microservice
spring.data.mongodb.uri=mongodb://127.0.0.1:27017/userdb
server.port=8002
```
Asegúrate de tener una instancia de MongoDB ejecutándose en localhost:27017 o modifica la URI según tu configuración.

## Estructura del Proyecto
```bash
Copiaruser-microservice/
├── src/    
│   ├── main/           
│   │   ├── java/   
│   │   │   └── com/microservicios/user_microservice/   
│   │   │       ├── controller/     
│   │   │       │   └── UserController.java     
│   │   │       ├── entity/     
│   │   │       │   └── UserEntity.java     
│   │   │       ├── repository/     
│   │   │       │   └── UserRepository.java     
│   │   │       ├── service/        
│   │   │       │   └── UserService.java    
│   │   │       └── UserMicroserviceApplication.java        
│   │   └── resources/  
│   │       └── application.properties  
│   └── test/   
│       └── java/       
│           └── com/microservicios/user_microservice/   
│               └── UserMicroserviceApplicationTests.java   
└── pom.xml     
```

## Instalación y Ejecución
### Clonar el repositorio
```bash
Copiargit clone <URL-del-repositorio>
cd user-microservice
```
### Compilar el proyecto
```bash
Copiar./mvnw clean package
```
### Ejecutar la aplicación
```bash
Copiar./mvnw spring-boot:run
```
La aplicación estará disponible en http://localhost:8002.

## Modelo de Datos
La entidad UserEntity contiene los siguientes campos:

- id: Identificador único del usuario
- name: Nombre del usuario
- lastName: Apellido del usuario
- role: Rol del usuario (ej. "ESTUDIANTE", "PROFESOR")

## API Endpoints
```bash
Método HTTP     Endpoint                                               Descripción
GET            /api/users                                              Obtiene todos los usuarios
GET            /api/users/{id}                                         Obtiene un usuario por su ID
POST           /api/users                                              Crea un nuevo usuario
PUT            /api/users/{id}                                         Actualiza un usuario existente
DELETE         /api/users/{id}                                         Elimina un usuario
GET            /api/users/role/{role}                                  Obtiene usuarios por rol
GET            /api/users/search?name={name}&lastName={lastName}       Busca usuarios por nombre y apellido
```
## Ejemplos de uso
### Obtener todos los usuarios
```bash
Copiarcurl -X GET http://localhost:8002/api/users
```
### Obtener un usuario por ID
```bash
Copiarcurl -X GET http://localhost:8002/api/users/1234567890
```
### Crear un nuevo usuario
```bash
Copiarcurl -X POST http://localhost:8002/api/users \
-H "Content-Type: application/json" \
-d '{"name":"Juan","lastName":"Pérez","role":"ESTUDIANTE"}'
```
### Actualizar un usuario
```bash
Copiarcurl -X PUT http://localhost:8002/api/users/1234567890 \
-H "Content-Type: application/json" \
-d '{"name":"Juan","lastName":"Pérez","role":"PROFESOR"}'
```
### Eliminar un usuario
```bash
Copiarcurl -X DELETE http://localhost:8002/api/users/1234567890
```
### Obtener usuarios por rol
```bash
Copiarcurl -X GET http://localhost:8002/api/users/role/ESTUDIANTE
```
### Buscar usuarios por nombre y apellido
```bash
Copiarcurl -X GET "http://localhost:8002/api/users/search?name=Juan&lastName=Pérez"
```
## Tecnologías Utilizadas

- Spring Boot 3.4.4
- Spring Data MongoDB
- MongoDB
- Lombok
- Maven

## Desarrollado Con

- Java 17
- Maven como gestor de dependencias
- Spring Boot como framework de aplicación
- MongoDB como base de datos

## Autor (es) ✒️

Este sitio fue realizado por:

* **Cristian Lesmes**
* **Jeffer Pinzon**