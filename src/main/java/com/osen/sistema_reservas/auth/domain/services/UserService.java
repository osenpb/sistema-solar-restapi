package com.osen.sistema_reservas.auth.domain.services;

import com.osen.sistema_reservas.auth.domain.models.User;
import com.osen.sistema_reservas.auth.infraestructure.dtos.UserResponse;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserResponse> findAll();
    User findById(Long id);
    UserResponse save(User user);
    void deleteById(Long id);
    Optional<User> findByEmail(String email);

}
