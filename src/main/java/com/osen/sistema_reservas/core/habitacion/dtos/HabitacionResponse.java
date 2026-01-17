package com.osen.sistema_reservas.core.habitacion.dtos;

import com.osen.sistema_reservas.core.tipoHabitacion.model.TipoHabitacion;

public record HabitacionResponse(
    Long id,
    String numero,
    String estado,
    Double precio,
    TipoHabitacion tipoHabitacion,
    Long hotelId

) {
}
