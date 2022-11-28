package com.toroparking.proyectosolid.Modelo.TipoVehiculos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarroTest {

    @Test
    public void esCarro () {
        Carro carro = new Carro();

        assertEquals("Carro", carro.tipoVehiculo());
    }

    @Test
    public void palcaCorrecta () {
        Carro carro = new Carro ();
        carro.setPlaca("HBK-123");

        assertEquals("HBK-123", carro.getPlaca());
    }
}