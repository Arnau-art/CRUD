package org.example.crud.Repository;

import org.example.crud.Entity.Espec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EspecRepository extends JpaRepository<Espec, Long> {


    @Query("SELECT e FROM Espec e WHERE e.rolEntity.nombre = :nombreRol")
    List<Espec> findByRolNombreCustom(@Param("nombreRol") String nombreRol);


    List<Espec> findByClaseId(Long claseId);
}