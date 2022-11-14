package com.toroparking.proyectosolid.Modelo.Servicios;

import com.toroparking.proyectosolid.Modelo.TipoVehiculos.Moto;
import com.toroparking.proyectosolid.Modelo.TipoVehiculos.Vehiculo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ServicioActivo extends Servicio implements Serializable {

    public ServicioActivo() {
    }

    @Override
    public String toString() {
        String strServicio = "Placa: " + vehiculo.getPlaca() + " - ";
        SimpleDateFormat formatoFecha = new SimpleDateFormat("MMMM dd, yyyy HH:mm:ss");
        if (vehiculo instanceof Moto) {
            strServicio += "MOTOCICLETA" + " - Ingreso: " + formatoFecha.format(fechaInicial.getTime());
        } else {
            strServicio += "AUTOMOVIL" + " - Ingreso: " + formatoFecha.format(fechaInicial.getTime());
        }
        return strServicio;
    }

    public ServicioActivo(Vehiculo vehiculo, Calendar fechaInicial) {
        super(vehiculo, fechaInicial);
    }

    public ServicioActivo(Vehiculo vehiculo, Calendar fechaInicial, Calendar fechaFinal) {
        super(vehiculo, fechaInicial, fechaFinal);
    }

}
