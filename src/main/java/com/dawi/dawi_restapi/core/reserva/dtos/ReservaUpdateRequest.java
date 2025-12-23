package com.dawi.dawi_restapi.core.reserva.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

/**
 * DTO para solicitud de actualización de fechas de reserva
 */
public record ReservaUpdateRequest(
        @NotNull(message = "La fecha de inicio es requerida")
        LocalDate fechaInicio,

        @NotNull(message = "La fecha de fin es requerida")
        LocalDate fechaFin
) {}
