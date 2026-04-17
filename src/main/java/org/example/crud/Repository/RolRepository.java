package org.example.crud.Repository;

import org.example.crud.Entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

    /**
     * Busca un rol por su nombre exacto (ej: "Tank", "Healer", "DPS").
     * Usamos Optional para evitar errores de NullPointerException si el rol no existe.
     */
    Optional<Rol> findByNombre(String nombre);
}
