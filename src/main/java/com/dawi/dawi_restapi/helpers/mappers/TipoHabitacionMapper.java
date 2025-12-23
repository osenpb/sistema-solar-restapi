package com.dawi.dawi_restapi.helpers.mappers;

import com.dawi.dawi_restapi.core.tipoHabitacion.dtos.TipoHabitacionResponse;
import com.dawi.dawi_restapi.core.tipoHabitacion.model.TipoHabitacion;

import java.util.List;

public class TipoHabitacionMapper {

    public static TipoHabitacionResponse toDTO(TipoHabitacion tipo) {
        if (tipo == null) return null;

        return new TipoHabitacionResponse(
                tipo.getId(),
                tipo.getNombre(),
                tipo.getDescripcion(),
                tipo.getCapacidad()
        );
    }

    public static List<TipoHabitacionResponse> toDTOList(List<TipoHabitacion> tipos) {
        return tipos.stream()
                .map(TipoHabitacionMapper::toDTO)
                .toList();
    }
}
