package com.toroparking.proyectosolid.Modelo.Configuracion;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ConfiguracionCapacidadesTest {

    @Test
    void agregarCapacidad() {
        ConfiguracionCapacidades capacidades = new ConfiguracionCapacidades();
        boolean resultadoEsperado = true, resultado;
        resultado = capacidades.agregarCapacidad("Avion", 1200);

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void modificarCapacidad() {
        ConfiguracionCapacidades capacidades = new ConfiguracionCapacidades();
        boolean resultadoEsperado = false, resultado;
        resultado =  capacidades.modificarCapacidad("Avion", 2000);
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void obtenerCapacidad() {
        ConfiguracionCapacidades capacidades = new ConfiguracionCapacidades();
        int resultadoEsperado = -1, resultado;
        resultado = capacidades.obtenerCapacidad("Locura");

        assertEquals(resultadoEsperado, resultado);
    }
}