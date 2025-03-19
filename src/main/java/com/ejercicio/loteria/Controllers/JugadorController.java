package com.ejercicio.loteria.Controllers;

import com.ejercicio.loteria.Services.ApuestaService;
import com.ejercicio.loteria.Services.JugadorService;
import com.ejercicio.loteria.entities.Apuesta;
import com.ejercicio.loteria.entities.Jugador;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/jugadores")
public class JugadorController {

    private static final Logger logger = LoggerFactory.getLogger(JugadorController.class);

    private final JugadorService jugadorService;
    private ApuestaService apuestaService;

    public JugadorController(JugadorService jugadorService, ApuestaService apuestaService) {
        this.apuestaService = apuestaService;
        this.jugadorService = jugadorService;
    }

    // Obtener todos los jugadores
    @GetMapping
    public List<Jugador> getAllJugadores() {
        logger.info("Llamada controlador a obtener todos los jugadores");
        return jugadorService.getAllJugadores();
    }

    // Obtener un jugador por ID
    @GetMapping("/{id}")
    public Jugador getJugadorById(@PathVariable Integer id) {
        logger.info("Llamada controlador a obtener jugador por id");
        return jugadorService.getJugadorById(id);
    }

    // Obtener un jugador por nombre
    @GetMapping("/nombre/{nombre}")
    public Jugador getJugadorByNombre(@PathVariable String nombre) {
        logger.info("Llamada controlador a obtener jugador por nombre");
        return jugadorService.getJugadorByNombre(nombre);
    }

    // Crear un nuevo jugador
    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public String createJugador(@ModelAttribute("jugador") Jugador jugador, Model model) {
        logger.info("Llamada controlador a crear jugador");
        jugadorService.saveJugador(jugador);
        List<Apuesta> apuestas = apuestaService.getApuestas();
        List<Jugador> jugadores = jugadorService.getAllJugadores();
        model.addAttribute("jugador", new Jugador());
        model.addAttribute("apuesta", new Apuesta());
        model.addAttribute("apuestaR", new Apuesta());
        model.addAttribute("apuestas", apuestas);
        model.addAttribute("jugadores", jugadores);
        return "index";
    }
}
