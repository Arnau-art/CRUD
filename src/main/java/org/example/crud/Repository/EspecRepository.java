package org.example.crud.Repository;
import org.example.crud.Entity.Espec;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EspecRepository extends JpaRepository<Espec, Long> {
    List<Espec> findByRolEntity_Nombre(String nombreRol);
}