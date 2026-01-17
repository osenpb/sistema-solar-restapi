package com.osen.sistema_reservas.auth.infraestructure.dtos;

public record AuthResponse(
        UserResponse user,
        String token
) {
}
