package com.toroparking.proyectosolid.Modelo.Configuracion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfiguracionCuposTest {

    @Test
    void aumentarCupo() {
        boolean resultadoEsperado = true, resultado;
        ConfiguracionCupos cupos = new ConfiguracionCupos();
        cupos.agregarCupo("Carro", 50);
        resultado = cupos.aumentarCupo("Carro");

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void reducirCupo() {
        boolean resultadoEsperado = false, resultado;
        ConfiguracionCupos cupos = new ConfiguracionCupos();
        resultado = cupos.reducirCupo("Carro");

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void agregarCupo() {
        boolean resultadoEsperado = false, resultado;
        ConfiguracionCupos cupos = new ConfiguracionCupos();
        cupos.agregarCupo("Moto", 50);
        resultado = cupos.agregarCupo("Moto", 50);

        assertEquals(resultadoEsperado, resultado);
    }
}