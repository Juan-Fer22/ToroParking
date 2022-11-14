package com.toroparking.proyectosolid.Modelo.Configuracion;

public interface IConfiguracionCupos {
    public boolean aumentarCupo (String tipo);
    public boolean reducirCupo (String tipo);
    public int obtenerCupo (String tipo);
    public boolean agregarCupo (String tipo, int cupo);
}
