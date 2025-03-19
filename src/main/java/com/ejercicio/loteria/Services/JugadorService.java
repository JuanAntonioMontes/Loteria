package com.ejercicio.loteria.Services;

import com.ejercicio.loteria.Controllers.ApuestaController;
import com.ejercicio.loteria.Repositores.JugadorRepository;
import com.ejercicio.loteria.entities.Jugador;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class JugadorService {

    private static final Logger logger = LoggerFactory.getLogger(JugadorService.class);

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
        logger.info("Llamada servicio a buscar jugador por id");
        return jugadorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jugador no encontrado con ID: " + id));
    }

    // Obtener un jugador por nombre
    public Jugador getJugadorByNombre(String nombre) {
        logger.info("Llamada servicio a buscar jugador por nombre");
        return jugadorRepository.findByNombre(nombre)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jugador no encontrado con nombre: " + nombre));
    }

    // Guardar o actualizar un jugador
    @Transactional
    public Jugador saveJugador(Jugador jugador) {
        logger.info("Llamada servicio a crear jugador");
        return jugadorRepository.save(jugador);
    }

}
