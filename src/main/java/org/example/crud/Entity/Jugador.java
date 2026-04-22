package org.example.crud.Entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "jugadores")
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "reino", nullable = false)
    private String reino;

    @Column(name = "region")
    private String region; // EU, US, KR, etc. (opcional pero recomendado)

    @Column(name = "clase")
    private String clase;

    @Column(name = "especializacion")
    private String especializacion;

    @Column(name = "puntuacion")
    private Integer puntuacion;



    // Constructor por defecto
    public Jugador() {}

    // Constructor completo
    public Jugador(String nombre, String reino, String region, String clase,
                   String especializacion, Integer puntuacion) {
        this.nombre = nombre;
        this.reino = reino;
        this.region = region;
        this.clase = clase;
        this.especializacion = especializacion;
        this.puntuacion = puntuacion;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getReino() { return reino; }
    public void setReino(String reino) { this.reino = reino; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    public String getClase() { return clase; }
    public void setClase(String clase) { this.clase = clase; }

    public String getEspecializacion() { return especializacion; }
    public void setEspecializacion(String especializacion) { this.especializacion = especializacion; }

    public Integer getPuntuacion() { return puntuacion; }
    public void setPuntuacion(Integer puntuacion) { this.puntuacion = puntuacion; }

}