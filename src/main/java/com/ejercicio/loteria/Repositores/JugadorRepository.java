package com.ejercicio.loteria.Repositores;

import com.ejercicio.loteria.entities.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Integer> {

    // Obtener un jugador por su nombre
    Optional<Jugador> findByNombre(String nombre);

}
