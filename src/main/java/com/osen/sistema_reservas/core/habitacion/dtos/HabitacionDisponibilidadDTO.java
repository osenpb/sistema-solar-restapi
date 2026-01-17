package com.osen.sistema_reservas.core.habitacion.dtos;

public record HabitacionDisponibilidadDTO(
        boolean disponible,
        int cantidad
) {
}
