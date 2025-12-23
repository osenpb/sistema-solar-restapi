package com.dawi.dawi_restapi.core.departamento.dtos;

/**
 * DTO para respuesta de departamento
 */
public record DepartamentoResponse(
        Long id,
        String nombre,
        String detalle
) {}
