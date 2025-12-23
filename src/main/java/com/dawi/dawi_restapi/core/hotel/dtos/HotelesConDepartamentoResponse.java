package com.dawi.dawi_restapi.core.hotel.dtos;

import com.dawi.dawi_restapi.core.departamento.dtos.DepartamentoResponse;

import java.util.List;

/**
 * DTO para respuesta de hoteles con su departamento
 */
public record HotelesConDepartamentoResponse(
        DepartamentoResponse departamento,
        List<HotelResponse> hoteles
) {}
