package com.osen.sistema_reservas.core.reserva.dtos;

import com.osen.sistema_reservas.core.cliente.dtos.ClienteRequest;

import java.time.LocalDate;
import java.util.List;

public record ReservaRequest(
        LocalDate fechaInicio,
        LocalDate fechaFin,
        ClienteRequest cliente,
        List<Long> habitacionesIds
) {
}
