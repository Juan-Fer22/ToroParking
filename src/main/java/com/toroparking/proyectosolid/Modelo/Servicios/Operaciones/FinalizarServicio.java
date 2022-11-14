package com.toroparking.proyectosolid.Modelo.Servicios.Operaciones;

import com.toroparking.proyectosolid.Modelo.Servicios.Servicio;
import com.toroparking.proyectosolid.Modelo.Servicios.ServicioFinalizado;
import com.toroparking.proyectosolid.Modelo.ToroParking;

import java.util.Calendar;

public class FinalizarServicio implements IFinalizarServicio{
    @Override
    public double finalizarServicio(int indiceServicio) {
        double respuesta = -1;
        Servicio servicio = ToroParking.getInstance().getServiciosEnCurso().get(indiceServicio);
        respuesta = servicio.calcularCosto();
        servicio.setFechaFinal(Calendar.getInstance());
        ToroParking.getInstance().getServiciosEnCurso().remove(indiceServicio);
        Servicio nuevoServicio = new ServicioFinalizado(servicio.getVehiculo(), servicio.getFechaInicial(), servicio.getFechaFinal(), respuesta);
        ToroParking.getInstance().getServiciosFinalizados().add(nuevoServicio);
        return respuesta;
    }
}
