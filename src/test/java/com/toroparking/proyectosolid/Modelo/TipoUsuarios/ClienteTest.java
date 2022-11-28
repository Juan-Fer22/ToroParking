package com.toroparking.proyectosolid.Modelo.TipoUsuarios;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class ClienteTest {

    @Test
    public void clienteCorrecto () {
        Cliente cliente = new Cliente("Andres", "1000228019", "AndresD2314", "Blackops2002", true);
        Cliente cliente1 = new Cliente("Andres", "1000228019", "AndresD2314", "Blackops2002", true);

        assertSame(cliente1,cliente);
    }

    @Test
    public void nombreCorrecto () {
        Cliente cliente = new Cliente();
        cliente.setNombre("Andres");

        assertEquals("Andres", cliente.getNombre());
    }

    @Test
    public void idCorrecto () {
        Cliente cliente = new Cliente();
        cliente.setID("1000228019");

        assertEquals("1000228019", cliente.getId());
    }

    @Test
    public void passwordCorrecto () {
        Cliente cliente = new Cliente();
        cliente.setPassword("Roma23");

        assertEquals("Roma23", cliente.getPassword());
    }

    @Test
    public void usuarioCorrecto () {
        Cliente cliente = new Cliente();
        cliente.setUsuario("AndresD2314");

        assertEquals("AndresD2314", cliente.getUsuario());
    }


}