package com.toroparking.proyectosolid.Modelo.Servicios.Operaciones;

import com.toroparking.proyectosolid.Modelo.Servicios.Servicio;
import com.toroparking.proyectosolid.Modelo.Servicios.ServicioActivo;
import com.toroparking.proyectosolid.Modelo.TipoUsuarios.Cliente;
import com.toroparking.proyectosolid.Modelo.TipoVehiculos.Carro;
import com.toroparking.proyectosolid.Modelo.TipoVehiculos.Moto;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class AgregarServicioTest {

    private AgregarServicio agregarServicio = new AgregarServicio();

    @Test
    void agregarServicio1() {
        Servicio s = new ServicioActivo(new Carro(new Cliente("Juan", "123", "342342"),"SDF321"), Calendar.getInstance(),null);
        agregarServicio.agregarServicio(s);
    }

    @Test
    void agregarServicio2() {
        Servicio s = new ServicioActivo(new Carro(), Calendar.getInstance(),null);
        agregarServicio.agregarServicio(s);
    }

    @Test
    void agregarServicio3() {
        Servicio s = new ServicioActivo(new Moto(new Cliente("Juan", "123", "342342"),"SDF321"), Calendar.getInstance(),null);
        agregarServicio.agregarServicio(s);
    }
}