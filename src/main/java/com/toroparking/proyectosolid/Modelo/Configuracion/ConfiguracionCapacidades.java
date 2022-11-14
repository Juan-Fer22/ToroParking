package com.toroparking.proyectosolid.Modelo.Configuracion;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class ConfiguracionCapacidades implements IConfiguracionCapacidades, Serializable {
    private Map<String, Integer> capacidades;

    public ConfiguracionCapacidades() {
        this.capacidades = new HashMap<>();
    }

    public ConfiguracionCapacidades(Map<String, Integer> capacidades) {
        this.capacidades = capacidades;
    }

    @Override
    public boolean agregarCapacidad(String tipo, int capacidad) {
        if (!capacidades.containsKey(tipo)) {
           capacidades.put(tipo, capacidad);
           return true;
        }
        return false;
    }

    @Override
    public boolean modificarCapacidad(String tipo, int capacidad) {
        if (capacidades.containsKey(tipo)) {
            capacidades.put(tipo, capacidad);
            return true;
        }
        return false;
    }

    @Override
    public int obtenerCapacidad(String tipo) {
        if (capacidades.containsKey(tipo)) {
            return capacidades.get(tipo);
        }
        return -1;
    }


}
