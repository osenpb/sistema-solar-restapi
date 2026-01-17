package com.osen.sistema_reservas.core.reserva.dtos;

import com.osen.sistema_reservas.core.cliente.dtos.ClienteRequest;

import java.time.LocalDate;
import java.util.List;

public record ReservaAdminUpdateDTO(
        LocalDate fechaInicio,
        LocalDate fechaFin,
        String estado,
        Long hotelId,
        ClienteRequest cliente,
        List<Long> habitaciones
) {
}
