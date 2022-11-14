package com.toroparking.proyectosolid.Modelo.Configuracion;

import lombok.Data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

@Data
public class ConfiguracionGeneral implements IGuardadoConfiguracion, Serializable {
    private IConfiguracionPersona administradores;
    private IConfiguracionPersona clientes;
    private IConfiguracionCosto costos;
    private IConfiguracionCapacidades configuracionCapacidades;
    private IConfiguracionCupos configuracionCupos;
    public String fecha;

    public ConfiguracionGeneral() {
        this.administradores = new ConfiguracionAdmin();
        this.clientes = new ConfiguracionCliente();
        this.costos = new ConfiguracionCostos();
        this.configuracionCapacidades = new ConfiguracionCapacidades();
        this.configuracionCupos = new ConfiguracionCupos();
    }

    public ConfiguracionGeneral(IConfiguracionPersona administradores, IConfiguracionPersona clientes, IConfiguracionCosto costos, IConfiguracionCapacidades configuracionCapacidades, IConfiguracionCupos configuracionCupos, String fecha) {
        this.administradores = administradores;
        this.clientes = clientes;
        this.costos = costos;
        this.configuracionCapacidades = configuracionCapacidades;
        this.configuracionCupos = configuracionCupos;
        this.fecha = fecha;
    }

    public String getFecha () {
        refrescarFecha();
        return fecha;
    }

    public void refrescarFecha () {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("MMMM dd, yyyy HH:mm:ss");
        fecha = formatoFecha.format(Calendar.getInstance().getTime());
    }

}
