package com.osen.sistema_reservas.core.hotel.dtos;

import com.osen.sistema_reservas.core.departamento.dtos.DepartamentoResponse;

import java.util.List;

/**
 * DTO para respuesta de hoteles con su departamento
 */
public record HotelesConDepartamentoResponse(
        DepartamentoResponse departamento,
        List<HotelResponse> hoteles
) {}
