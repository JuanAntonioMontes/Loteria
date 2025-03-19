package com.ejercicio.loteria.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "jugador")
public class Jugador {

    @Column(name = "nombre")
    public String nombre;
    @Id
    private Long id;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public Jugador() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
