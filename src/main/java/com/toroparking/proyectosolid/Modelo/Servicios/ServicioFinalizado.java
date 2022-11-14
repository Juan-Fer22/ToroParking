package com.toroparking.proyectosolid.Modelo.Servicios;

import com.toroparking.proyectosolid.Modelo.TipoVehiculos.Moto;
import com.toroparking.proyectosolid.Modelo.TipoVehiculos.Vehiculo;
import com.toroparking.proyectosolid.Modelo.ToroParking;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ServicioFinalizado extends Servicio implements Serializable {

    public ServicioFinalizado() {
        super();
    }

    public ServicioFinalizado(Vehiculo vehiculo, Calendar fechaInicial, Calendar fechaFinal, double costoFinal) {
        super( vehiculo, fechaInicial, fechaFinal, costoFinal);
    }

    public ServicioFinalizado(Vehiculo vehiculo, Calendar fechaInicial) {
        super(vehiculo, fechaInicial);
    }

    @Override
    public String toString() {
        String strServicio = "Placa: " + vehiculo.getPlaca() + " - ";
        SimpleDateFormat formatoFecha = new SimpleDateFormat("MMMM dd, yyyy HH:mm:ss");
        if(vehiculo instanceof Moto)
        {
            strServicio += "MOTOCICLETA - Completado: " + formatoFecha.format(fechaFinal.getTime()) + " - Costo Final: " + costoTotalServicio + " - Costo por Minuto: " + ToroParking.getInstance().getConfiguracionGeneral().getCostos().buscar(vehiculo.tipoVehiculo());
        }
        else
        {
            strServicio += "AUTOMOVIL- Completado: " + formatoFecha.format(fechaFinal.getTime())+ " - Costo Final: " + costoTotalServicio + " - Costo por Minuto: " + ToroParking.getInstance().getConfiguracionGeneral().getCostos().buscar(vehiculo.tipoVehiculo()).get();
        }
        return strServicio;
    }

}
