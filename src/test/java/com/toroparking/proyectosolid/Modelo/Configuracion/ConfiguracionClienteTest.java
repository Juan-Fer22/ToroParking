package com.toroparking.proyectosolid.Modelo.Configuracion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfiguracionClienteTest {

    @Test
    void buscar() {
        boolean resultadoEsperado = true, resultado;
        ConfiguracionCliente cliente = new ConfiguracionCliente();
        try {
            cliente.agregar("Juan", "123456", null, "43543534");
        } catch (Exception e) {
            e.printStackTrace();
        }
        resultado = cliente.buscar("123456").isPresent();

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void agregar() {
        boolean resultadoEsperado = true, resultado = false;
        ConfiguracionCliente cliente = new ConfiguracionCliente();
        try {
            resultado = cliente.agregar("Juan", "123456", null, "43543534");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void eliminar() {
        boolean resultadoEsperado = false, resultado = false;
        ConfiguracionCliente cliente = new ConfiguracionCliente();
        resultado = cliente.buscar("123453").isPresent();

        assertEquals(resultadoEsperado, resultado);
    }
}