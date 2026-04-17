package org.example.crud.Entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, unique = true)
    private String nombre; // Ejemplo: "Tank", "Healer", "DPS"

    // Relación: Un Rol tiene muchas Especializaciones
    // Usamos List para facilitar el manejo con JavaFX (ListView/TableView)
    @OneToMany(mappedBy = "rolEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Espec> especificaciones = new ArrayList<>();

    public Rol() {}

    public Rol(String nombre) {
        this.nombre = nombre;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Espec> getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(List<Espec> especificaciones) {
        this.especificaciones = especificaciones;
    }

    // El toString es vital para que en el JavaFX se vea el nombre en los botones o combos
    @Override
    public String toString() {
        return nombre;
    }
}