package com.microservicios.user_microservice.service;

import com.microservicios.user_microservice.entity.UserEntity;
import com.microservicios.user_microservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /**
     * Obtiene todos los usuarios registrados
     * @return Lista de usuarios
     */
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Busca un usuario por su ID
     * @param id Identificador del usuario
     * @return Usuario encontrado o null si no existe
     */
    public UserEntity getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    /**
     * Crea un nuevo usuario
     * @param user Datos del usuario a crear
     * @return Usuario creado
     */
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    /**
     * Actualiza un usuario existente
     * @param user Datos actualizados del usuario
     * @return Usuario actualizado o null si no existe
     */
    public UserEntity updateUser(UserEntity user) {
        if (userRepository.existsById(user.getId())) {
            return userRepository.save(user);
        }
        return null;
    }

    /**
     * Elimina un usuario por su ID
     * @param id Identificador del usuario a eliminar
     */
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    /**
     * Busca usuarios por rol
     * @param role Rol a filtrar
     * @return Lista de usuarios con el rol especificado
     */
    public List<UserEntity> getUsersByRole(String role) {
        return userRepository.findByUserRole(role);
    }

    /**
     * Busca usuarios por nombre o apellido
     * @param name Nombre o apellido a buscar
     * @return Lista de usuarios que coinciden
     */
    public List<UserEntity> searchUsersByName(String name) {
        return userRepository.findByUserNameContainingIgnoreCaseOrUserLastNameContainingIgnoreCase(name, name);
    }
}