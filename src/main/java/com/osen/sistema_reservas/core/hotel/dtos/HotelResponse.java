package com.osen.sistema_reservas.core.hotel.dtos;

import com.osen.sistema_reservas.core.habitacion.dtos.HabitacionResponse;
import com.osen.sistema_reservas.core.departamento.model.Departamento;

import java.util.List;

public record HotelResponse(
        // este podria ser HotelResponse, pero ya seria refactorizar el front tmb
        Long id,
        String nombre,
        String direccion,
        Departamento departamento,
        List<HabitacionResponse> habitaciones,
        String imagenUrl
) {
}
