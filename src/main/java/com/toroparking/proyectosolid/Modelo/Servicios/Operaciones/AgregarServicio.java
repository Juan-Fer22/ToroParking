package com.toroparking.proyectosolid.Modelo.Servicios.Operaciones;

import com.toroparking.proyectosolid.Modelo.Servicios.Servicio;
import com.toroparking.proyectosolid.Modelo.ToroParking;

public class AgregarServicio implements IAgregarServicio {
    @Override
    public boolean agregarServicio(Servicio servicio) {
        for (Servicio s : ToroParking.getInstance().getServiciosEnCurso()) {
            if (s.getVehiculo().getPlaca().equals(servicio.getVehiculo().getPlaca())) {
                return false;
            }
        }
        ToroParking.getInstance().getServiciosEnCurso().add(servicio);

        return true;
    }
}
