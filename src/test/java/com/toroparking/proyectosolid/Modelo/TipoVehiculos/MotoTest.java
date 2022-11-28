package com.toroparking.proyectosolid.Modelo.TipoVehiculos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MotoTest {

    @Test
    public void esMoto () {
        Moto moto = new Moto();

        assertEquals("Moto", moto.tipoVehiculo());
    }

    @Test
    public void placaCorrecta () {
        Moto moto = new Moto();
        moto.setPlaca("JRT-123");
        assertEquals("JRT-123", moto.getPlaca());
    }
}