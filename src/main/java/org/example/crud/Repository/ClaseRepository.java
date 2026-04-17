package org.example.crud.Repository;

import org.example.crud.Entity.Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaseRepository extends JpaRepository<Clase, Long> {
    // Aquí puedes añadir métodos personalizados en el futuro si los necesitas,
    // por ahora con los métodos heredados de JpaRepository (save, findAll, etc.) es suficiente.
}