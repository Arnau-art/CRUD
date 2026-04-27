package org.example.crud.Repository;

import org.example.crud.Entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
    // buscar un rol por su nombre en lugar de por ID desde tu Service.
    Optional<Rol> findByNombre(String nombre);
}