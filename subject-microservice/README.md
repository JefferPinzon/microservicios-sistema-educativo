# Microservicio de Asignaturas (Subject Microservice)

Este microservicio forma parte de una arquitectura de microservicios para la gestión académica, encargándose específicamente de la administración de materias o asignaturas académicas.

## Descripción

El microservicio de asignaturas proporciona una API RESTful que permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre entidades de tipo asignatura (Subject). Está desarrollado con Spring Boot y utiliza MongoDB como base de datos para almacenar la información.

## Tecnologías

- Java 17
- Spring Boot 3.4.4
- Spring Data MongoDB
- Spring Cloud OpenFeign
- Spring Validation
- Lombok
- OpenAPI/Swagger
- Maven

## Requisitos previos

- JDK 17 o superior
- MongoDB 4.4 o superior
- Maven 3.8 o superior

## Configuración

El archivo `application.properties` contiene la configuración básica del microservicio:

```properties
spring.application.name=subject-microservice
spring.data.mongodb.uri=mongodb://127.0.0.1:27017/subjectdb
server.port=8001
```

Para modificar la conexión a MongoDB o el puerto del servidor, edita este archivo.

## Instalación y ejecución

### Clonar el repositorio

```bash
git clone [URL_DEL_REPOSITORIO]
cd subject-microservice
```

### Compilar el proyecto

```bash
./mvnw clean package
```

### Ejecutar el microservicio

```bash
./mvnw spring-boot:run
```

O ejecutar el JAR generado:

```bash
java -jar target/subject-microservice-0.0.1-SNAPSHOT.jar
```

## Estructura del proyecto

```
subject-microservice/
├── src/
│   ├── main/
│   │   ├── java/com/microservicios/subject_microservice/
│   │   │   ├── controller/
│   │   │   │   └── SubjectController.java
│   │   │   ├── entity/
│   │   │   │   └── SubjectEntity.java
│   │   │   ├── repository/
│   │   │   │   └── SubjectRepository.java
│   │   │   ├── service/
│   │   │   │   └── SubjectService.java
│   │   │   └── SubjectMicroserviceApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/com/microservicios/subject_microservice/
│           └── SubjectMicroserviceApplicationTests.java
├── .mvn/
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## Modelo de datos

La entidad principal es `SubjectEntity` con los siguientes atributos:

- `id`: Identificador único de la asignatura (generado automáticamente)
- `subjectName`: Nombre de la asignatura
- `subjectCode`: Código de la asignatura
- `teacherId`: Identificador del profesor que imparte la asignatura

## API REST

El microservicio expone los siguientes endpoints a través de `SubjectController`:

### Obtener todas las asignaturas

```
GET /api/subjects
```

**Respuesta**: Lista de asignaturas o 204 No Content si no hay asignaturas.

### Obtener asignatura por ID

```
GET /api/subjects/{id}
```

**Parámetros**:
- `id`: Identificador único de la asignatura

**Respuesta**: Asignatura encontrada o 404 Not Found si no existe.

### Crear nueva asignatura

```
POST /api/subjects
```

**Cuerpo de la petición**: Objeto JSON con datos de la asignatura
```json
{
  "subjectName": "Matemáticas",
  "subjectCode": "MAT101",
  "teacherId": "teacher123"
}
```

**Respuesta**: Asignatura creada con su ID generado.

### Actualizar asignatura

```
PUT /api/subjects
```

**Cuerpo de la petición**: Objeto JSON con datos de la asignatura, incluyendo ID
```json
{
  "id": "asignatura123",
  "subjectName": "Matemáticas Avanzadas",
  "subjectCode": "MAT201",
  "teacherId": "teacher123"
}
```

**Respuesta**: Asignatura actualizada o 404 Not Found si no existe.

### Eliminar asignatura

```
DELETE /api/subjects/{id}
```

**Parámetros**:
- `id`: Identificador único de la asignatura

**Respuesta**: 200 OK si se eliminó correctamente.

### Obtener asignaturas por profesor

```
GET /api/subjects/teacher/{teacherId}
```

**Parámetros**:
- `teacherId`: Identificador del profesor

**Respuesta**: Lista de asignaturas del profesor o 204 No Content si no hay asignaturas.

### Obtener asignaturas por código

```
GET /api/subjects/code/{subjectCode}
```

**Parámetros**:
- `subjectCode`: Código de la asignatura

**Respuesta**: Lista de asignaturas con ese código o 204 No Content si no hay asignaturas.

## Documentación de la API

La documentación de la API está disponible a través de OpenAPI/Swagger UI en:

```
http://localhost:8001/swagger-ui.html
```

## Tests

Para ejecutar los tests:

```bash
./mvnw test
```

## Integración con otros microservicios

Este microservicio está preparado para integrarse con otros servicios mediante OpenFeign. Actualmente no tiene implementadas llamadas a otros microservicios, pero la dependencia está configurada en el `pom.xml` para futuras integraciones.

## Autor (es) ✒️

Este sitio fue realizado por:

* **Cristian Lesmes**
* **Jeffer Pinzon**