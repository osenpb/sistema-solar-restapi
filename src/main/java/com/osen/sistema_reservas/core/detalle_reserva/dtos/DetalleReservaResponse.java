package com.osen.sistema_reservas.core.detalle_reserva.dtos;

public record DetalleReservaResponse(
        Long id,
        Long habitacionId,
        double precioNoche
) {}