package com.ejercicio.loteria.Controllers;

import com.ejercicio.loteria.dtos.ApuestaDTO;
import com.ejercicio.loteria.entities.Apuesta;
import com.ejercicio.loteria.Services.ApuestaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/api/apuestas")
public class ApuestaController {

    private ApuestaService apuestaService;

    public ApuestaController(ApuestaService apuestaService){
        this.apuestaService = apuestaService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Apuesta> crearApuesta(@RequestBody ApuestaDTO apuesta, @PathVariable Integer userId) {
        return ResponseEntity.ok(apuestaService.createApuesta(apuesta, userId));
    }

    @PostMapping("/random/{userId}")
    public ResponseEntity<Apuesta> crearApuestaRandom(@PathVariable Integer userId) {
        return ResponseEntity.ok(apuestaService.createApuestaRandom(userId));
    }
}
