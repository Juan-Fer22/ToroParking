package com.toroparking.proyectosolid.Modelo.TipoUsuarios;

import java.io.Serializable;

public class Administrador extends Usuario implements Serializable {
    public Administrador() {
        super ();
    }

    public Administrador(String nombre, String id, String usuario, String password) {
        super(nombre, id, usuario, password);
    }

    public Administrador (String usuario, String password) {
        super (usuario, password);
    }

    @Override
    public String toString() {
        return
                "Nombre: " + nombre +
                ", ID: " + id +
                ", Usuario: " + usuario +
                ", Password: " + password;
    }
}
