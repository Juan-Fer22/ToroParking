package com.toroparking.proyectosolid.Modelo.Configuracion;

import java.util.Optional;

public interface IConfiguracionPersona {
    public Optional<?> buscar (String id);
    public boolean agregar (String nombre, String id, String user, String pass);
    public boolean eliminar (String id);
}
