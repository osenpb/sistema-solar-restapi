package com.dawi.dawi_restapi.api.admin;

import com.dawi.dawi_restapi.core.departamento.dtos.DepartamentoRequest;
import com.dawi.dawi_restapi.core.departamento.dtos.DepartamentoResponse;
import com.dawi.dawi_restapi.core.departamento.model.Departamento;
import com.dawi.dawi_restapi.core.departamento.service.DepartamentoService;
import com.dawi.dawi_restapi.helpers.dtos.MessageResponse;
import com.dawi.dawi_restapi.helpers.mappers.DepartamentoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/departamentos")
@RequiredArgsConstructor
public class AdminDepartamentoController {

    private final DepartamentoService departamentoService;

    /**
     * Lista todos los departamentos
     */
    @GetMapping
    public ResponseEntity<List<DepartamentoResponse>> listar() {
        List<Departamento> departamentos = departamentoService.listar();
        List<DepartamentoResponse> response = DepartamentoMapper.toDTOList(departamentos);
        return ResponseEntity.ok(response);
    }

    /**
     * Obtiene un departamento por ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoResponse> obtener(@PathVariable Long id) {
        Departamento departamento = departamentoService.buscarPorId(id);
        DepartamentoResponse response = DepartamentoMapper.toDTO(departamento);
        return ResponseEntity.ok(response);
    }

    /**
     * Crea un nuevo departamento
     */
    @PostMapping
    public ResponseEntity<DepartamentoResponse> crear(@RequestBody @Valid DepartamentoRequest request) {
        Departamento departamento = departamentoService.crear(request);
        DepartamentoResponse response = DepartamentoMapper.toDTO(departamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Actualiza un departamento existente
     */
    @PutMapping("/{id}")
    public ResponseEntity<DepartamentoResponse> actualizar(
            @PathVariable Long id,
            @RequestBody @Valid DepartamentoRequest request) {

        Departamento departamento = departamentoService.actualizar(id, request);
        DepartamentoResponse response = DepartamentoMapper.toDTO(departamento);
        return ResponseEntity.ok(response);
    }

    /**
     * Elimina un departamento
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> eliminar(@PathVariable Long id) {
        departamentoService.eliminar(id);
        return ResponseEntity.ok(MessageResponse.of("Departamento eliminado correctamente"));
    }
}
