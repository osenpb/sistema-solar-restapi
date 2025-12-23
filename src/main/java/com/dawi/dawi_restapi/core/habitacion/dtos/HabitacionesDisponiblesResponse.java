package com.dawi.dawi_restapi.core.habitacion.dtos;

import java.time.LocalDate;
import java.util.List;

/**
 * DTO para respuesta de habitaciones disponibles
 */
public record HabitacionesDisponiblesResponse(
        Long hotelId,
        String hotelNombre,
        LocalDate fechaInicio,
        LocalDate fechaFin,
        List<HabitacionResponse> habitacionesDisponibles,
        int cantidad
) {}
