package com.toroparking.proyectosolid.Modelo.TipoVehiculos;

import com.toroparking.proyectosolid.Modelo.TipoUsuarios.Cliente;

public class Bicicleta extends Vehiculo {

    public Bicicleta() {
        super();
    }

    public Bicicleta(Cliente propietario, String placa) {
        super (propietario, placa);
    }
    @Override
    public String tipoVehiculo() {
        return TipoVehiculo.Bicicleta.toString();
    }
}
