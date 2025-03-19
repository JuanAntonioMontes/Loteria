package com.ejercicio.loteria.Services;

import com.ejercicio.loteria.Repositores.JugadorRepository;
import com.ejercicio.loteria.dtos.ApuestaDTO;
import com.ejercicio.loteria.entities.Apuesta;
import com.ejercicio.loteria.Repositores.ApuestaRepository;
import com.ejercicio.loteria.entities.Jugador;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ApuestaService {

    private final ApuestaRepository apuestaRepository;

    private final JugadorRepository jugadorRepository;

    public ApuestaService(ApuestaRepository apuestaRepository, JugadorRepository jugadorRepository) {
        this.apuestaRepository = apuestaRepository;
        this.jugadorRepository = jugadorRepository;
    }

    @Transactional
    public Apuesta createApuesta(ApuestaDTO apuestadto, Integer juagadorId) {
        Jugador jugador = jugadorRepository.findById(juagadorId).orElseThrow();
        Apuesta apuesta = new Apuesta(apuestadto.numero1(), apuestadto.numero2(), apuestadto.numero3(), apuestadto.numero4(), apuestadto.numero5(), apuestadto.numero6(), jugador);
        return apuestaRepository.save(apuesta);
    }
}
