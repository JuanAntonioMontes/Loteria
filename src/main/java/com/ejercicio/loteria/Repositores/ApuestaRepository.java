package com.ejercicio.loteria.Repositores;

import com.ejercicio.loteria.entities.Apuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ApuestaRepository extends JpaRepository<Apuesta, Integer> {

}
