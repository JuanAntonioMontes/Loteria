package com.ejercicio.loteria.Services;

import com.ejercicio.loteria.Repositores.JugadorRepository;
import com.ejercicio.loteria.dtos.ApuestaDTO;
import com.ejercicio.loteria.entities.Apuesta;
import com.ejercicio.loteria.Repositores.ApuestaRepository;
import com.ejercicio.loteria.entities.Jugador;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class ApuestaService {

    private final ApuestaRepository apuestaRepository;

    private final JugadorRepository jugadorRepository;

    Random random = new Random();
    private static final Logger logger = LoggerFactory.getLogger(ApuestaService.class);

    public ApuestaService(ApuestaRepository apuestaRepository, JugadorRepository jugadorRepository) {
        this.apuestaRepository = apuestaRepository;
        this.jugadorRepository = jugadorRepository;
    }

    @Transactional
    public Apuesta createApuesta(ApuestaDTO apuestadto, Integer jugadorId) {
        logger.info("Se ha intentado introducir un jugador ya existente");
        validarNumerosApuesta(apuestadto);
        List<Apuesta> apuestaLista = apuestaRepository.findAllByJugadorId(jugadorId);
        Jugador jugador = jugadorRepository.findById(jugadorId).orElseThrow();
        Apuesta apuesta = new Apuesta(apuestadto.numero1(), apuestadto.numero2(), apuestadto.numero3(), apuestadto.numero4(), apuestadto.numero5(), apuestadto.numero6(), jugador);
        for (Apuesta a:apuestaLista){
            if (a.getNumero1().equals(apuesta.getNumero1()) &&
                    a.getNumero2().equals(apuesta.getNumero2()) &&
                    a.getNumero3().equals(apuesta.getNumero3()) &&
                    a.getNumero4().equals(apuesta.getNumero4()) &&
                    a.getNumero5().equals(apuesta.getNumero5()) &&
                    a.getNumero6().equals(apuesta.getNumero6())) {
                logger.error("Ya existe una apuesta con los números: " +
                        apuesta.getNumero1() + ", " +
                        apuesta.getNumero2() + ", " +
                        apuesta.getNumero3() + ", " +
                        apuesta.getNumero4() + ", " +
                        apuesta.getNumero5() + ", " +
                        apuesta.getNumero6());
                throw new RuntimeException("Ya existe una apuesta con esos números");
            }
        }
        return apuestaRepository.save(apuesta);
    }

    public Apuesta createApuestaRandom(Integer jugadorId) {
        Set<Integer> numeros = new HashSet<>();
        Random random = new Random();
        Jugador jugador = jugadorRepository.findById(jugadorId).orElseThrow();

        while (numeros.size() < 6) {
            numeros.add(random.nextInt(49) + 1); // Genera un número entre 1 y 49
        }

        Integer[] numerosArray = numeros.toArray(new Integer[0]);

        return new Apuesta(
                numerosArray[0], numerosArray[1], numerosArray[2],
                numerosArray[3], numerosArray[4], numerosArray[5],
                jugador
        );
    }

    private void validarNumerosApuesta(ApuestaDTO apuestadto) {
        int[] numeros = {apuestadto.numero1(), apuestadto.numero2(), apuestadto.numero3(),
                apuestadto.numero4(), apuestadto.numero5(), apuestadto.numero6()};

        for (int numero : numeros) {
            if (numero < 1 || numero > 49) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Número fuera de rango: " + numero + ". Debe estar entre 1 y 49.");
            }
        }
    }
}
