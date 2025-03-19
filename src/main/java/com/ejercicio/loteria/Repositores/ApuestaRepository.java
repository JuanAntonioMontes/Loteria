package com.ejercicio.loteria.Repositores;

import com.ejercicio.loteria.entities.Apuesta;
import com.ejercicio.loteria.entities.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApuestaRepository extends JpaRepository<Apuesta, Integer> {

    @Query("SELECT a FROM Apuesta a WHERE a.numero1 = :num1 AND a.numero2 = :num2 AND a.numero3 = :num3 " +
            "AND a.numero4 = :num4 AND a.numero5 = :num5 AND a.numero6 = :num6 AND a.jugador.id = :jugadorId")
    Optional<Apuesta> findDuplicateApuesta(
            @Param("num1") Integer numero1,
            @Param("num2") Integer numero2,
            @Param("num3") Integer numero3,
            @Param("num4") Integer numero4,
            @Param("num5") Integer numero5,
            @Param("num6") Integer numero6,
            @Param("jugadorId") Integer jugadorId
    );

    @Query("SELECT a FROM Apuesta a WHERE a.jugador.id = :jugadorId")
    List<Apuesta> findAllByJugadorId(@Param("jugadorId") Integer jugadorId);
}
