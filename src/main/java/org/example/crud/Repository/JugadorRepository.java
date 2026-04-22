package org.example.crud.Repository;

import org.example.crud.Entity.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long> {

    List<Jugador> findByClaseIgnoreCase(String clase);

    List<Jugador> findByEspecializacion(String especializacion);
}