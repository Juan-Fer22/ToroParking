package com.toroparking.proyectosolid.Modelo.Configuracion;

import com.toroparking.proyectosolid.Modelo.TipoUsuarios.Administrador;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Optional;

@Data
public class ConfiguracionAdmin implements IConfiguracionPersona, Serializable {
    private ArrayList<Administrador> administradores;

    public ConfiguracionAdmin() {
        administradores = new ArrayList<>();
    }

    public ConfiguracionAdmin(ArrayList<Administrador> administradores) {
        this.administradores = administradores;
    }

    public boolean agregar (String nombre, String id, String user, String pass) {
        for (Administrador a : administradores) {
            if (a.getUsuario().equals(user)) {
                return false;
            }
        }
        Administrador admin = new Administrador(nombre, id, user, pass);
        administradores.add(admin);
        return true;
    }

    @Override
    public boolean eliminar(String id) {
        Optional<?> admin = buscar(id);
        if (admin.isPresent()) {
            for (int i = 0; i < administradores.size(); i++) {
                if(administradores.get(i).equals(admin.get())) {
                    administradores.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public Optional<?> buscar (String id) {
        for (Administrador a : administradores) {
            if (a.getId().equalsIgnoreCase(id)) {
                return Optional.of(a);
            }
        }
        return Optional.empty();
    }

    public boolean iniciarSesion (String usuario, String id) {
        for (Administrador a : administradores) {
            if (a.getUsuario().equals(usuario) && a.getPassword().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
