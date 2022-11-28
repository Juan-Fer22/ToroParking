package com.toroparking.proyectosolid.Modelo.Configuracion;

import com.toroparking.proyectosolid.Modelo.Configuracion.ConfiguracionAdmin;
import com.toroparking.proyectosolid.Modelo.TipoUsuarios.Administrador;
import com.toroparking.proyectosolid.Modelo.TipoUsuarios.Usuario;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ConfiguracionAdminTest {

    @Test
    void agregar() {
        boolean resultadoEsperado = true, resultado;
        ConfiguracionAdmin admin = new ConfiguracionAdmin();
        resultado = admin.agregar("pancho", "123456789", "destructor", "password");

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void eliminar() {
        boolean resultadoEsperado = false, resultado;
        ConfiguracionAdmin admin = new ConfiguracionAdmin();
        resultado = admin.eliminar("123456789");

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void buscar() {
        Optional<Administrador> resultadoEsperado = Optional.empty();
        Optional<?> resultado;
        ConfiguracionAdmin admin = new ConfiguracionAdmin();
        resultado = admin.buscar("34932042");

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void iniciarSesion() {
        boolean resultadoEsperado = false, resultado;
        ConfiguracionAdmin admin = new ConfiguracionAdmin();
        resultado = admin.iniciarSesion("destructor", "123");

        assertEquals(resultadoEsperado, resultado);
    }
}