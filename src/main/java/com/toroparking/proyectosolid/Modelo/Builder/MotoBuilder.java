package com.toroparking.proyectosolid.Modelo.Builder;

import com.toroparking.proyectosolid.Modelo.TipoUsuarios.Cliente;
import com.toroparking.proyectosolid.Modelo.TipoVehiculos.Carro;
import com.toroparking.proyectosolid.Modelo.TipoVehiculos.Moto;

public class MotoBuilder implements Builder {
    private Cliente propietario;
    private String placa;

    @Override
    public void setPropietario(Cliente propietario) {
        this.propietario = propietario;
    }

    @Override
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Moto getMoto() {
        return new Moto(propietario, placa);
    }
}
