package com.dawi.dawi_restapi.core.departamento.dtos;

import jakarta.validation.constraints.NotBlank;

/**
 * DTO para crear o actualizar un departamento
 */
public record DepartamentoRequest(
        @NotBlank(message = "El nombre es requerido")
        String nombre,

        String detalle
) {}
