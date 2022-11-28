package com.toroparking.proyectosolid.Modelo.Builder;

import com.toroparking.proyectosolid.Modelo.TipoUsuarios.Cliente;
import com.toroparking.proyectosolid.Modelo.TipoVehiculos.Carro;

public class CarroBuilder implements Builder {

    private Cliente propietario;
    private String placa;

    public CarroBuilder() {
        this.propietario = new Cliente();
    }

    @Override
    public void setPropietario(Cliente propietario) {
        this.propietario = propietario;
    }

    @Override
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Carro getCarro() {
        return new Carro(propietario, placa);
    }
}
