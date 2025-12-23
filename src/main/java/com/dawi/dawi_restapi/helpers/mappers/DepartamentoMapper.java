package com.dawi.dawi_restapi.helpers.mappers;

import com.dawi.dawi_restapi.core.departamento.dtos.DepartamentoResponse;
import com.dawi.dawi_restapi.core.departamento.model.Departamento;

import java.util.List;

public class DepartamentoMapper {

    public static DepartamentoResponse toDTO(Departamento departamento) {
        if (departamento == null) return null;

        return new DepartamentoResponse(
                departamento.getId(),
                departamento.getNombre(),
                departamento.getDetalle() != null ? departamento.getDetalle() : ""
        );
    }

    public static List<DepartamentoResponse> toDTOList(List<Departamento> departamentos) {
        return departamentos.stream()
                .map(DepartamentoMapper::toDTO)
                .toList();
    }
}
