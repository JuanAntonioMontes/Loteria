package com.ejercicio.loteria.Controllers;

import com.ejercicio.loteria.Services.JugadorService;
import com.ejercicio.loteria.entities.Jugador;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorController {

    private final JugadorService jugadorService;

    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    // Obtener todos los jugadores
    @GetMapping
    public List<Jugador> getAllJugadores() {
        return jugadorService.getAllJugadores();
    }

    // Obtener un jugador por ID
    @GetMapping("/{id}")
    public Jugador getJugadorById(@PathVariable Integer id) {
        return jugadorService.getJugadorById(id);
    }

    // Obtener un jugador por nombre
    @GetMapping("/nombre/{nombre}")
    public Jugador getJugadorByNombre(@PathVariable String nombre) {
        return jugadorService.getJugadorByNombre(nombre);
    }

    // Crear un nuevo jugador
    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public String createJugador(@ModelAttribute("jugador") Jugador jugador) {
        jugadorService.saveJugador(jugador);
        return "index";
    }
}
