package org.example.crud.Service;

import org.example.crud.Entity.Clase;
import org.example.crud.Entity.Espec;
import org.example.crud.Repository.ClaseRepository;
import org.example.crud.Repository.EspecRepository;
import org.example.crud.Repository.RolRepository; // Añadido
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WoWService {
    private final EspecRepository especRepository;
    private final ClaseRepository claseRepository;
    private final RolRepository rolRepository; // Añadido

    public WoWService(EspecRepository especRepository, ClaseRepository claseRepository, RolRepository rolRepository) {
        this.especRepository = especRepository;
        this.claseRepository = claseRepository;
        this.rolRepository = rolRepository;
    }

    // Método genérico que sirve para Tank, Healer o DPS
    public List<Espec> getEspecsPorRol(String nombreRol) throws Exception {
        // Validación (Requisito 2.2: Mensajes de error)
        rolRepository.findByNombre(nombreRol)
                .orElseThrow(() -> new Exception("El rol " + nombreRol + " no existe."));

        // Uso de Streams para filtrar y ordenar (Requisito 2.3)
        return especRepository.findAll().stream()
                .filter(e -> e.getRolEntity().getNombre().equalsIgnoreCase(nombreRol))
                .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
                .collect(Collectors.toList());
    }

    public List<Espec> getAllEspec() {
        return especRepository.findAll();
    }
}