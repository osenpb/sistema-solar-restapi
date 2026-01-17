package com.osen.sistema_reservas.core.detalle_reserva.service;

import com.osen.sistema_reservas.core.detalle_reserva.model.DetalleReserva;
import com.osen.sistema_reservas.core.detalle_reserva.repository.DetalleReservaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DetalleReservaService {

    private final DetalleReservaRepository detalleReservaRepository;

    public DetalleReserva guardar(DetalleReserva detalleReserva) {
        return detalleReservaRepository.save(detalleReserva);
    }

}
