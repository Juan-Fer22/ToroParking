package com.toroparking.proyectosolid.Modelo.Configuracion;

public interface IConfiguracionCapacidades {
    public boolean agregarCapacidad (String tipo, int capacidad);
    public boolean modificarCapacidad (String tipo, int capacidad);
    public int obtenerCapacidad (String tipo);

}
