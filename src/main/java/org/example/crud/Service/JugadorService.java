package org.example.crud.Service;

import org.example.crud.Entity.Espec;
import org.example.crud.Entity.Jugador;
import org.example.crud.Repository.EspecRepository;
import org.example.crud.Repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    @Autowired
    private EspecRepository especRepository;

    public Jugador guardarJugadorConValidacion(String nombre, String reino, String region,
                                               String clase, String especializacion, Integer puntuacion) {

        // 1. Comprobar que la especialización existe y pertenece a la clase
        Optional<Espec> especOpt = especRepository.findByNameAndClaseName(especializacion, clase);
        if (especOpt.isEmpty()) {
            throw new IllegalArgumentException(
                    "La especialización \"" + especializacion +
                            "\" no pertenece a la clase \"" + clase + "\"."
            );
        }

        // 2. Crear y guardar el jugador
        Jugador jugador = new Jugador(
                nombre, reino, region,
                clase, especializacion, puntuacion
        );

        return jugadorRepository.save(jugador);
    }

    public List<Jugador> listarJugadoresPorClase(String clase) {
        return jugadorRepository.findByClaseIgnoreCase(clase);
    }

    public List<Jugador> listarTodosLosJugadores() {
        return jugadorRepository.findAll();
    }
}