package com.toroparking.proyectosolid.Modelo.TipoUsuarios;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class UsuarioTest {

    @Test
    public void usuarioCorrecto () {
        Usuario usuario = new Usuario("Andres", "1000228019", "AndresD2314", "Roma23");
        Usuario usuario1 = new Usuario("Andres", "1000228019", "AndresD2314", "Roma23");

        assertSame(usuario1,usuario);
    }
}