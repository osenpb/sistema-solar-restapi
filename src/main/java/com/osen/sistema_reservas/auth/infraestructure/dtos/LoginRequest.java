package com.osen.sistema_reservas.auth.infraestructure.dtos;

public record LoginRequest(
        String email,

        String password
) {
}
