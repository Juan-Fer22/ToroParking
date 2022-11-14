package com.toroparking.proyectosolid.Modelo.TipoVehiculos;

import com.toroparking.proyectosolid.Modelo.TipoUsuarios.Cliente;

import java.io.Serializable;

public class Moto extends Vehiculo implements Serializable {

    public Moto() {
        super();
    }

    public Moto(Cliente propietario, String placa) {
        super(propietario, placa);
    }

    @Override
    public String tipoVehiculo() {
        return "Moto";
    }
}
