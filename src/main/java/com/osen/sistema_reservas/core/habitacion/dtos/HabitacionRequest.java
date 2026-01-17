package com.osen.sistema_reservas.core.habitacion.dtos;

public record HabitacionRequest(
                      // puede ser null para nuevas
        String numero,
        String estado,
        double precio,
        Long tipoHabitacionId
) {
}
