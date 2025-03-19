package com.ejercicio.loteria.Controllers;

import com.ejercicio.loteria.Services.JugadorService;
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

    public ApuestaController(ApuestaService apuestaService){
        this.apuestaService = apuestaService;
    }

    @PostMapping("/crear")
    public String crearApuesta(@ModelAttribute("apuesta") Apuesta apuesta) {
        apuestaService.createApuesta(apuesta);
        return "index";
    }

    @GetMapping("/list")
    public String getApuestas(Model model) {
        List<Apuesta> apuestas = apuestaService.getApuestas();
        List<Jugador> jugadores = jugadorService.getAllJugadores();
        Apuesta apuesta = new Apuesta();
        apuestas.add(apuesta);
        model.addAttribute("jugador", new Jugador());
        model.addAttribute("apuesta", new Apuesta());
        model.addAttribute("apuestas", apuestas);
        model.addAttribute("jugadores", jugadores);
        return "index";
    }
}
