package com.toroparking.proyectosolid.Modelo.Servicios.Operaciones;

import com.toroparking.proyectosolid.Modelo.Servicios.Servicio;
import com.toroparking.proyectosolid.Modelo.Servicios.ServicioActivo;

import java.util.regex.Pattern;

public class CrearServicio implements ICrearServicio{

    @Override
    public Servicio crearServicio(String vehiculo, String placa) {
        Servicio nuevoServicio = new ServicioActivo();
        nuevoServicio.setVehiculo(vehiculo);
        if(Pattern.matches("([A-Z]){3}([0-9]){3}", placa)) {
            nuevoServicio.getVehiculo().setPlaca(placa);
        } else if (Pattern.matches("([A-Z]){3}([0-9]){2}[A-Z]", placa)) {
            nuevoServicio.getVehiculo().setPlaca(placa);
        }
        return nuevoServicio;
    }
}
