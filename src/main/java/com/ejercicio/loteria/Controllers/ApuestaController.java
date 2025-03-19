package com.ejercicio.loteria.Controllers;

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

    @PostMapping
    public ResponseEntity<Apuesta> crearApuesta(@RequestBody Apuesta apuesta) {
        return ResponseEntity.ok(apuestaService.createApuesta(apuesta));
    }
}
