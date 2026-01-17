package com.osen.sistema_reservas.core.departamento.dtos;

import jakarta.validation.constraints.NotBlank;


public record DepartamentoRequest(
        @NotBlank(message = "El nombre es requerido")
        String nombre,

        String detalle
) {}
