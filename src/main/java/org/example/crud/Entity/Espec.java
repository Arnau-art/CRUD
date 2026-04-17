package org.example.crud.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Especializaciones")
public class Espec {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    // Este campo lo usaremos para mostrar el texto en la ventana de detalles
    @Column(name = "descripcion", length = 500)
    private String descripcion;

    @Column(name = "rol_tipo", nullable = false)
    private String rolTipo; // Mantiene el String por si lo usas de forma auxiliar

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clase_id")
    private Clase clase;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rol_id")
    private Rol rolEntity;

    // Constructores
    public Espec() {}

    public Espec(String name, String descripcion, String rolTipo, Clase clase, Rol rolEntity) {
        this.name = name;
        this.descripcion = descripcion;
        this.rolTipo = rolTipo;
        this.clase = clase;
        this.rolEntity = rolEntity;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getRolTipo() { return rolTipo; }
    public void setRolTipo(String rolTipo) { this.rolTipo = rolTipo; }

    public Clase getClase() { return clase; }
    public void setClase(Clase clase) { this.clase = clase; }

    public Rol getRolEntity() { return rolEntity; }
    public void setRolEntity(Rol rolEntity) { this.rolEntity = rolEntity; }

    @Override
    public String toString() {
        return name; // Simplificado para que el TableView o ListView se vea limpio
    }
}