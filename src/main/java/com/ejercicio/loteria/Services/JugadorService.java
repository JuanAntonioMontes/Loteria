package com.ejercicio.loteria.Services;

import com.ejercicio.loteria.Repositores.JugadorRepository;
import com.ejercicio.loteria.entities.Jugador;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class JugadorService {

    private final JugadorRepository jugadorRepository;

    public JugadorService(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    // Obtener todos los jugadores
    public List<Jugador> getAllJugadores() {
        return jugadorRepository.findAll();
    }

    // Obtener un jugador por ID
    public Jugador getJugadorById(Integer id) {
        return jugadorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jugador no encontrado con ID: " + id));
    }

    // Obtener un jugador por nombre
    public Jugador getJugadorByNombre(String nombre) {
        return jugadorRepository.findByNombre(nombre)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jugador no encontrado con nombre: " + nombre));
    }

    // Guardar o actualizar un jugador
    @Transactional
    public Jugador saveJugador(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

}
