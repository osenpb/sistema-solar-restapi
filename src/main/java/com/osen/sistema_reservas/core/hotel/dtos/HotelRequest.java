package com.osen.sistema_reservas.core.hotel.dtos;

import com.osen.sistema_reservas.core.habitacion.dtos.HabitacionRequest;

import java.util.List;

public record HotelRequest(
        // este es para casos de update, x eso no ocupa id
        String nombre,
        String direccion,
        Long departamentoId,
        List<HabitacionRequest> habitaciones,
        String imagenUrl
        ) {

}
