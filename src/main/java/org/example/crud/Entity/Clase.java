package org.example.crud.Entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Clases")

public class Clase implements Comparable<Clase> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "clase", orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<Espec> espec = new HashSet<>();

    public Clase() {}
    public Clase(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(Clase otra) {
        return this.name.compareTo(otra.getName());
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Set<Espec> getEspec() { return espec; }
    public void setEspec(Set<Espec> espec) { this.espec = espec; }

    @Override
    public String toString() {
        return name;
    }
}
