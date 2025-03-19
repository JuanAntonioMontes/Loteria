package com.ejercicio.loteria.Services;

import com.ejercicio.loteria.Repositores.JugadorRepository;
import com.ejercicio.loteria.dtos.ApuestaDTO;
import com.ejercicio.loteria.entities.Apuesta;
import com.ejercicio.loteria.Repositores.ApuestaRepository;
import com.ejercicio.loteria.entities.Jugador;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.List;

@Service
public class ApuestaService {

    private final ApuestaRepository apuestaRepository;

    private final JugadorRepository jugadorRepository;

    public ApuestaService(ApuestaRepository apuestaRepository, JugadorRepository jugadorRepository) {
        this.apuestaRepository = apuestaRepository;
        this.jugadorRepository = jugadorRepository;
    }

    @Transactional
    public Apuesta createApuesta(ApuestaDTO apuestadto, Integer jugadorId) {

        List<Apuesta> apuestaLista = apuestaRepository.findAll();
        Jugador jugador = jugadorRepository.findById(jugadorId).orElseThrow();
        Apuesta apuesta = new Apuesta(apuestadto.numero1(), apuestadto.numero2(), apuestadto.numero3(), apuestadto.numero4(), apuestadto.numero5(), apuestadto.numero6(), jugador);
        for (Apuesta a:apuestaLista){
            if (a.getJugador().getId().equals(jugadorId) &&
                    a.getNumero1().equals(apuesta.getNumero1()) &&
                    a.getNumero2().equals(apuesta.getNumero2()) &&
                    a.getNumero3().equals(apuesta.getNumero3()) &&
                    a.getNumero4().equals(apuesta.getNumero4()) &&
                    a.getNumero5().equals(apuesta.getNumero5()) &&
                    a.getNumero6().equals(apuesta.getNumero6())) {
                throw new RuntimeException("Ya existe una apuesta con esos números");
            }
        }
        return apuestaRepository.save(apuesta);
    }
}
