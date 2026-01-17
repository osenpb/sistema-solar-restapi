package com.osen.sistema_reservas.core.reserva.dtos;

import com.osen.sistema_reservas.core.cliente.dtos.ClienteResponse;
import com.osen.sistema_reservas.core.detalle_reserva.dtos.DetalleReservaResponse;
import com.osen.sistema_reservas.core.hotel.dtos.HotelResponse;

import java.time.LocalDate;
import java.util.List;

public record ReservaResponse(
        Long id,
        LocalDate fechaReserva,
        LocalDate fechaInicio,
        LocalDate fechaFin,
        double total,
        String estado,
        HotelResponse hotel,
        ClienteResponse cliente,
        List<DetalleReservaResponse> detalles
) {}
