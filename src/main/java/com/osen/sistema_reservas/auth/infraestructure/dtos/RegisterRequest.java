package com.osen.sistema_reservas.auth.infraestructure.dtos;

public record RegisterRequest(

        String username,

        String email,

        String password,

        String telefono

) {
}
