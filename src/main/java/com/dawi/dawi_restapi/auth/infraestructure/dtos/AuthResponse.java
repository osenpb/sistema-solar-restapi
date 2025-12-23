package com.dawi.dawi_restapi.auth.infraestructure.dtos;

public record AuthResponse(
        UserResponse user,
        String token
) {
}
