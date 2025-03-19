package com.ejercicio.loteria.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "jugador")
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Genera el ID automáticamente
    private Integer id;

    @Column(unique = true, nullable = false)
    private String nombre;

    public Jugador() {
    }

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
