package com.toroparking.proyectosolid.Modelo.Servicios.Operaciones;

import com.toroparking.proyectosolid.Modelo.Servicios.Servicio;
import com.toroparking.proyectosolid.Modelo.Servicios.ServicioActivo;
import com.toroparking.proyectosolid.Modelo.TipoUsuarios.Cliente;
import com.toroparking.proyectosolid.Modelo.TipoVehiculos.Moto;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class OperacionGeneralTest {

    @Test
    void buscar() {
        OperacionGeneral operacionGeneral = new OperacionGeneral();
        int resultadoEsperado = 0, resultado;
        Servicio s = new ServicioActivo(new Moto(new Cliente(), "ABC123"), Calendar.getInstance(), null);
        operacionGeneral.agregar(s);
        resultado = operacionGeneral.buscar(s);
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void crear() {
        boolean resultadoEsperado = true, resultado = false;
        OperacionGeneral operacionGeneral = new OperacionGeneral();
        if (operacionGeneral.crear("Moto", "DSF321") != null) {
            resultado = true;
        }
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void agregar() {
        OperacionGeneral operacionGeneral = new OperacionGeneral();
        boolean resultadoEsperado = false, resultado = false;
        resultado = operacionGeneral.agregar(new ServicioActivo(new Moto(new Cliente(), "ABC123"), Calendar.getInstance(), null));
        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void finalizar() {
        OperacionGeneral operacionGeneral = new OperacionGeneral();
        boolean resultadoEsperado = true, resultado = false;
        Servicio s = new ServicioActivo(new Moto(new Cliente(), "ABC123"), Calendar.getInstance(), null);
        operacionGeneral.agregar(s);
        if (operacionGeneral.finalizar(0) > 0) {
            resultado = true;
        }
        assertEquals(resultadoEsperado, resultado);

    }
}