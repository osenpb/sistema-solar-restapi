package com.osen.sistema_reservas.auth.infraestructure.dtos;

import com.osen.sistema_reservas.auth.domain.models.Role;

public record UserResponse(
        Long id,
        String username,
        String email,
        Role role
) {

}
