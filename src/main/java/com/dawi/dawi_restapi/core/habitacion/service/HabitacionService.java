package com.dawi.dawi_restapi.core.habitacion.service;

import com.dawi.dawi_restapi.core.habitacion.models.Habitacion;
import com.dawi.dawi_restapi.core.habitacion.repository.HabitacionRepository;
import com.dawi.dawi_restapi.helpers.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HabitacionService {

    private final HabitacionRepository habitacionRepository;

    public long contarTodas() {
        return habitacionRepository.count();
    }

    public Habitacion buscarPorId(Long id) {
        return habitacionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Habitacion", id));
    }

    public Optional<Habitacion> buscarPorIdOptional(Long id) {
        return habitacionRepository.findById(id);
    }

    public List<Habitacion> buscarPorIds(List<Long> ids) {
        return habitacionRepository.findAllById(ids);
    }

    public List<Habitacion> buscarPorHotelId(Long hotelId) {
        return habitacionRepository.findByHotelId(hotelId);
    }

    public void eliminarPorId(Long id) {
        if (!habitacionRepository.existsById(id)) {
            throw new EntityNotFoundException("Habitacion", id);
        }
        habitacionRepository.deleteById(id);
    }

    public int obtenerCantidadDisponible(Long hotelId, LocalDate inicio, LocalDate fin) {
        return habitacionRepository.contarDisponibles(hotelId, inicio, fin);
    }

    public boolean estaDisponible(Long habitacionId, LocalDate inicio, LocalDate fin) {
        int conflictos = habitacionRepository
                .contarReservasPorHabitacionYFechas(habitacionId, inicio, fin);
        return conflictos == 0;
    }
}
