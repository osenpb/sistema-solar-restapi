package com.dawi.dawi_restapi.core.hotel.dtos;

import com.dawi.dawi_restapi.core.departamento.dtos.DepartamentoResponse;
import com.dawi.dawi_restapi.core.habitacion.dtos.HabitacionResponse;

import java.util.List;

/**
 * DTO para respuesta con detalle completo de un hotel
 */
public record HotelDetalleResponse(
        HotelInfo hotel,
        DepartamentoResponse departamento,
        List<HabitacionResponse> habitaciones
) {
    /**
     * Información básica del hotel
     */
    public record HotelInfo(
            Long id,
            String nombre,
            String direccion,
            double precioMinimo,
            int cantidadHabitaciones
    ) {}
}
