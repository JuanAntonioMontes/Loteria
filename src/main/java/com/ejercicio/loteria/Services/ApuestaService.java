package com.ejercicio.loteria.Services;

import com.ejercicio.loteria.entities.Apuesta;
import com.ejercicio.loteria.Repositores.ApuestaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ApuestaService {

    private final ApuestaRepository apuestaRepository;

    public ApuestaService(ApuestaRepository apuestaRepository) {
        this.apuestaRepository = apuestaRepository;
    }

    @Transactional
    public Apuesta createApuesta(Apuesta apuesta){
        return apuestaRepository.save(apuesta);
    }
}
