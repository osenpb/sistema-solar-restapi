package com.dawi.dawi_restapi.core.cliente.service;

import com.dawi.dawi_restapi.auth.domain.models.User;
import com.dawi.dawi_restapi.core.cliente.dtos.ClienteRequest;
import com.dawi.dawi_restapi.core.cliente.model.Cliente;
import com.dawi.dawi_restapi.core.cliente.repository.ClienteRepository;
import com.dawi.dawi_restapi.helpers.exceptions.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente buscarPorDni(String dni) {
        return clienteRepository.findByDni(dni)
                .orElseThrow(() -> new EntityNotFoundException("Cliente", dni));
    }

    public Optional<Cliente> buscarPorDniOptional(String dni) {
        return clienteRepository.findByDni(dni);
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente", id));
    }

    public Optional<Cliente> buscarPorUserId(Long userId) {
        return clienteRepository.findByUserId(userId);
    }

    public Optional<Cliente> buscarPorEmail(String email) {
        return clienteRepository.findByEmail(email);
    }

    /**
     * Crea un nuevo cliente o actualiza uno existente.
     * Si el usuario está autenticado, busca por userId (cada usuario tiene su propio cliente).
     * Si no está autenticado, busca por DNI (comportamiento legacy).
     */
    public Cliente crearOActualizar(ClienteRequest dto, User user) {
        // Si hay usuario autenticado, buscar cliente por userId
        if (user != null) {
            Optional<Cliente> clienteDelUsuario = clienteRepository.findByUserId(user.getId());

            if (clienteDelUsuario.isPresent()) {
                // Actualizar datos del cliente existente del usuario
                Cliente cliente = clienteDelUsuario.get();
                cliente.setNombre(dto.nombre());
                cliente.setApellido(dto.apellido());
                cliente.setDni(dto.dni());
                cliente.setEmail(dto.email());
                if (dto.telefono() != null && !dto.telefono().isBlank()) {
                    cliente.setTelefono(dto.telefono());
                }
                return clienteRepository.save(cliente);
            } else {
                // Crear nuevo cliente para este usuario
                Cliente nuevo = new Cliente();
                nuevo.setNombre(dto.nombre());
                nuevo.setApellido(dto.apellido());
                nuevo.setDni(dto.dni());
                nuevo.setEmail(dto.email());
                nuevo.setTelefono(dto.telefono() != null && !dto.telefono().isBlank() ? dto.telefono() : "");
                nuevo.setUser(user);
                return clienteRepository.save(nuevo);
            }
        }

        // Sin usuario autenticado: comportamiento legacy por DNI
        Optional<Cliente> existente = clienteRepository.findByDni(dto.dni());

        if (existente.isPresent()) {
            Cliente cliente = existente.get();
            cliente.setNombre(dto.nombre());
            cliente.setApellido(dto.apellido());
            cliente.setEmail(dto.email());
            if (dto.telefono() != null && !dto.telefono().isBlank()) {
                cliente.setTelefono(dto.telefono());
            }
            return clienteRepository.save(cliente);
        }

        Cliente nuevo = new Cliente();
        nuevo.setNombre(dto.nombre());
        nuevo.setApellido(dto.apellido());
        nuevo.setDni(dto.dni());
        nuevo.setEmail(dto.email());
        nuevo.setTelefono(dto.telefono() != null && !dto.telefono().isBlank() ? dto.telefono() : "");
        return clienteRepository.save(nuevo);
    }

    /**
     * Crea un nuevo cliente o actualiza uno existente basándose en el DNI.
     */
    public Cliente crearOActualizar(ClienteRequest dto) {
        return crearOActualizar(dto, null);
    }
}