package com.toroparking.proyectosolid.Modelo.TipoVehiculos;

import com.toroparking.proyectosolid.Modelo.TipoUsuarios.Cliente;
import lombok.Data;

import java.io.Serializable;

@Data
public abstract class Vehiculo implements IVehiculo, Serializable {
    protected Cliente propietario;
    protected String placa;

    public Vehiculo() {
        this.propietario = new Cliente();
        this.placa = "";
    }

    public Vehiculo(Cliente propietario, String placa) {
        this.propietario = propietario;
        this.placa = placa;
    }
    public abstract String tipoVehiculo ();
}
