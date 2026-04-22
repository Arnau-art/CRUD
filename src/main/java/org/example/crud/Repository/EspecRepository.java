package org.example.crud.Repository;
import org.example.crud.Entity.Espec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EspecRepository extends JpaRepository<Espec, Long> {
    List<Espec> findByRolEntity_Nombre(String nombreRol);

    @Query("SELECT e FROM Espec e WHERE e.name = :nombre AND e.clase.name = :claseNombre")
    Optional<Espec> findByNameAndClaseName(
            @Param("nombre") String nombre,
            @Param("claseNombre") String claseNombre);
}