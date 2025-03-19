package com.ejercicio.loteria.Controllers;

import com.ejercicio.loteria.Services.JugadorService;
import com.ejercicio.loteria.dtos.ApuestaDTO;
import com.ejercicio.loteria.entities.Apuesta;
import com.ejercicio.loteria.Services.ApuestaService;
import com.ejercicio.loteria.entities.Jugador;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@Controller
@RequestMapping("/api/apuestas")
public class ApuestaController {

    private ApuestaService apuestaService;

    private JugadorService jugadorService;

    public ApuestaController(ApuestaService apuestaService, JugadorService jugadorService){
        this.apuestaService = apuestaService;
        this.jugadorService = jugadorService;
    }

    @PostMapping("/crear")
    public String crearApuesta(@ModelAttribute("apuesta") ApuestaDTO apuesta, @ModelAttribute("jugador") Jugador jugador, Model model) {
        apuestaService.createApuesta(apuesta, jugador.getId());
        List<Apuesta> apuestas = apuestaService.getApuestas();
        List<Jugador> jugadores = jugadorService.getAllJugadores();
        model.addAttribute("jugador", new Jugador());
        model.addAttribute("apuesta", new Apuesta());
        model.addAttribute("apuestas", apuestas);
        model.addAttribute("jugadores", jugadores);
        return "index";
    }

    @GetMapping("/list")
    public String getApuestas(Model model) {
        List<Apuesta> apuestas = apuestaService.getApuestas();
        List<Jugador> jugadores = jugadorService.getAllJugadores();
        model.addAttribute("jugador", new Jugador());
        model.addAttribute("apuesta", new Apuesta());
        model.addAttribute("apuestas", apuestas);
        model.addAttribute("jugadores", jugadores);
        return "index";
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Apuesta> crearApuesta(@RequestBody ApuestaDTO apuesta, @PathVariable Integer userId) {
        return ResponseEntity.ok(apuestaService.createApuesta(apuesta, userId));
    }
}
