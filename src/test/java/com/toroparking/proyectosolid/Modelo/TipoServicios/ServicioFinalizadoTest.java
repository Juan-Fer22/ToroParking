package com.toroparking.proyectosolid.Modelo.TipoServicios;

import com.toroparking.proyectosolid.Modelo.Servicios.ServicioFinalizado;
import com.toroparking.proyectosolid.Modelo.TipoVehiculos.Carro;
import com.toroparking.proyectosolid.Modelo.TipoVehiculos.Moto;
import com.toroparking.proyectosolid.Modelo.TipoVehiculos.Vehiculo;
import com.toroparking.proyectosolid.Modelo.ToroParking;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioFinalizadoTest {

    @Test
    public void toStringCorrectoMoto () {
        ServicioFinalizado servicioFinalizado = new ServicioFinalizado();
        Vehiculo vehiculo = new Moto();

        Calendar fechaF = Calendar.getInstance();
        fechaF = servicioFinalizado.getFechaFinal();

        assertEquals("Placa: HBK-123 - MOTOCICLETA - Completado: " +
                fechaF + " - Costo Final: " + servicioFinalizado.getCostoTotalServicio()
                + " - Costo por Minuto: " +  ToroParking.getInstance().getConfiguracionGeneral().getCostos().buscar(vehiculo.tipoVehiculo()).get(), servicioFinalizado.toString());
    }

    @Test
    public void toStringCorrectoCarro () {
        ServicioFinalizado servicioFinalizado = new ServicioFinalizado();
        Vehiculo vehiculo = new Carro();

        Calendar fechaF = Calendar.getInstance();
        fechaF = servicioFinalizado.getFechaFinal();

        assertEquals("Placa: HBK-123 - AUTOMOVIL - Completado: " +
                fechaF + " - Costo Final: " + servicioFinalizado.getCostoTotalServicio()
                + " - Costo por Minuto: " +  ToroParking.getInstance().getConfiguracionGeneral().getCostos().buscar(vehiculo.tipoVehiculo()).get(), servicioFinalizado.toString());
    }
}