package com.toroparking.proyectosolid.Modelo.Servicios.Operaciones;

import com.toroparking.proyectosolid.Modelo.Servicios.Servicio;
import com.toroparking.proyectosolid.Modelo.ToroParking;

public class BuscarServicio implements IBuscarServicio{
    @Override
    public int buscarServicio(Servicio servicio) {
        int i = 0;
        for (Servicio ser : ToroParking.getInstance().getServiciosEnCurso()) {
            if (ser.equals(servicio)) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
