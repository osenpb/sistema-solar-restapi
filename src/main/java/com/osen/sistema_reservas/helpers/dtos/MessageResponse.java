package com.osen.sistema_reservas.helpers.dtos;

/**
 * DTO genérico para respuestas con mensajes simples.
 * Reemplaza el uso de Map.of("message", "...")
 */
public record MessageResponse(
        String message
) {
    public static MessageResponse of(String message) {
        return new MessageResponse(message);
    }
}
