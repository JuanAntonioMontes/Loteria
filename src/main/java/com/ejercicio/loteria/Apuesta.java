package com.ejercicio.loteria;

import jakarta.persistence.*;
import jakarta.websocket.ClientEndpoint;

@Entity
@Table(name = "apuestas")
public class Apuesta{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "numero1")
    private Integer numero1;

    @Column(name = "numero2")
    private Integer numero2;

    @Column(name = "numero3")
    private Integer numero3;

    @Column(name = "numero4")
    private Integer numero4;

    @Column(name = "numero5")
    private Integer numero5;

    @Column(name = "numero6")
    private Integer numero6;

    public Apuesta(Integer numero1, Integer numero2, Integer numero6, Integer numero5, Integer numero4, Integer numero3) {
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.numero6 = numero6;
        this.numero5 = numero5;
        this.numero4 = numero4;
        this.numero3 = numero3;
    }

    public Integer getId() {
        return id;
    }

    public Integer getNumero1() {
        return numero1;
    }

    public void setNumero1(Integer numero1) {
        this.numero1 = numero1;
    }

    public Integer getNumero6() {
        return numero6;
    }

    public void setNumero6(Integer numero6) {
        this.numero6 = numero6;
    }

    public Integer getNumero5() {
        return numero5;
    }

    public void setNumero5(Integer numero5) {
        this.numero5 = numero5;
    }

    public Integer getNumero4() {
        return numero4;
    }

    public void setNumero4(Integer numero4) {
        this.numero4 = numero4;
    }

    public Integer getNumero2() {
        return numero2;
    }

    public void setNumero2(Integer numero2) {
        this.numero2 = numero2;
    }

    public Integer getNumero3() {
        return numero3;
    }

    public void setNumero3(Integer numero3) {
        this.numero3 = numero3;
    }
}
