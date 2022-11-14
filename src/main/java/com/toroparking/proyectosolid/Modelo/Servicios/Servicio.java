package com.toroparking.proyectosolid.Modelo.Servicios;

import com.toroparking.proyectosolid.Modelo.TipoVehiculos.Vehiculo;
import com.toroparking.proyectosolid.Modelo.ToroParking;
import lombok.Data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

@Data
public abstract class Servicio implements ITipoServicio, Serializable {
    protected Vehiculo vehiculo;
    protected Calendar fechaInicial;
    protected Calendar fechaFinal;
    protected double costoTotalServicio;

    public Servicio() {
        this.vehiculo = null;
        this.fechaInicial = Calendar.getInstance();
        this.fechaFinal = null;
        this.costoTotalServicio = 0.0;
    }

    public Servicio(Vehiculo vehiculo, Calendar fechaInicial) {
        this.vehiculo = vehiculo;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = null;
        this.costoTotalServicio = 0.0;

    }

    public Servicio(Vehiculo vehiculo, Calendar fechaInicial, Calendar fechaFinal) {
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.vehiculo = vehiculo;
    }

    public Servicio(Vehiculo vehiculo, Calendar fechaInicial, Calendar fechaFinal, double costoTotalServicio) {
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.vehiculo = vehiculo;
        this.costoTotalServicio = costoTotalServicio;
    }

    @Override
    public double calcularCosto() {
        Calendar momentoActual = Calendar.getInstance();
        long milliActual = momentoActual.getTimeInMillis();
        long milliComienzo = this.fechaInicial.getTimeInMillis();
        long diferenciaMilli = milliActual - milliComienzo;
        long minutosParqueado = TimeUnit.MILLISECONDS.toMinutes(diferenciaMilli);
        if (ToroParking.getInstance().getConfiguracionGeneral().getCostos().buscar(vehiculo.tipoVehiculo()).isPresent()) {
            this.costoTotalServicio = (minutosParqueado * (double) ToroParking.getInstance().getConfiguracionGeneral().getCostos().buscar(vehiculo.tipoVehiculo()).get()) + (double) ToroParking.getInstance().getConfiguracionGeneral().getCostos().buscar(vehiculo.tipoVehiculo()).get();
        }
        return this.costoTotalServicio;
    }

    @Override
    public abstract String toString();

    public void setVehiculo(String vehiculo) {
        try {
            this.vehiculo = (Vehiculo) Class.forName("com.toroparking.proyectosolid.Modelo.TipoVehiculos." + vehiculo).newInstance();
        } catch (ClassNotFoundException ce) {
            System.out.println("Vehiculo no valido.");
        } catch (InstantiationException | IllegalAccessException e) {
            System.out.println("Error al crear el vehiculo seleccionado.");
        }
    }

    public String getStringFechaInicial () {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("MMMM dd, yyyy HH:mm:ss");
        return formatoFecha.format(fechaInicial.getTime());
    }
}
