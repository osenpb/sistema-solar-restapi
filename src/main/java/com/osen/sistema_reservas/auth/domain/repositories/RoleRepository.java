package com.osen.sistema_reservas.auth.domain.repositories;

import com.osen.sistema_reservas.auth.domain.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
