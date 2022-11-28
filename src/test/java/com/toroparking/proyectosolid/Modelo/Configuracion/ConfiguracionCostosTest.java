package com.toroparking.proyectosolid.Modelo.Configuracion;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ConfiguracionCostosTest {

    @Test
    void buscar() {
        ConfiguracionCostos costos = new ConfiguracionCostos();
        boolean resultadoEsperado = true, resultado;
        costos.agregar("Carro", 100);
        resultado = costos.buscar("Carro").isPresent();

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void agregar() {
        ConfiguracionCostos costos = new ConfiguracionCostos();
        boolean resultadoEsperado = false, resultado;
        costos.agregar("Carro", 100);
        resultado = costos.agregar("Carro", 300);

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void modificar() {
        ConfiguracionCostos costos = new ConfiguracionCostos();
        boolean resultadoEsperado = true, resultado;
        costos.agregar("Moto", 300);
        resultado = costos.modificar("Moto", 100);

        assertEquals(resultadoEsperado, resultado);
    }
}