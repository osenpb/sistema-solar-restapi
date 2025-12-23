package com.dawi.dawi_restapi.core.reserva.dtos;

/**
 * DTO para respuesta de actualización de reserva
 */
public record ReservaUpdateResponse(
        String message,
        double nuevoTotal
) {
    public static ReservaUpdateResponse of(double nuevoTotal) {
        return new ReservaUpdateResponse("Reserva actualizada exitosamente", nuevoTotal);
    }
}
