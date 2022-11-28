package com.toroparking.proyectosolid.Modelo.Builder;

import com.toroparking.proyectosolid.Modelo.TipoUsuarios.Cliente;

public interface Builder {

    void setPropietario(Cliente propietario);

    void setPlaca(String placa);
}
