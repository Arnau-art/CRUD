package org.example.crud.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "Especializaciones")
public class Espec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String descripcion;
    private String rolTipo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clase_id")
    private Clase clase;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rol_id")
    private Rol rolEntity;

    public Espec() {}
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
}