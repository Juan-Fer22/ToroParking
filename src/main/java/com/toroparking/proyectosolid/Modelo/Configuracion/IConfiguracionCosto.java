package com.toroparking.proyectosolid.Modelo.Configuracion;

import java.util.Optional;

public interface IConfiguracionCosto {
    public Optional<?> buscar (String tipo);

    public boolean agregar (String tipo, double valor);

    public  boolean modificar (String tipo, double valor);

    public boolean eliminar (String tipo);


}
