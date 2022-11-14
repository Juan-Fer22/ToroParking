package com.toroparking.proyectosolid.Modelo.Configuracion;

import com.toroparking.proyectosolid.Modelo.TipoUsuarios.Administrador;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ConfiguracionCostos implements IConfiguracionCosto, Serializable {
    public Map<String, Double> costos;

    public ConfiguracionCostos() {
        costos = new HashMap<>();
    }

    public ConfiguracionCostos(Map<String, Double> costos) {
        this.costos = costos;
    }

    public Optional<?> buscar (String tipo) {
        return Optional.of(this.costos.get(tipo));
    }

    public boolean agregar (String tipo, double valor) {
        if (!this.costos.containsKey(tipo)){
            this.costos.put(tipo, valor);
            return true;
        }
        return false;
    }

    public boolean modificar (String tipo, double valor) {
        if (this.costos.containsKey(tipo)){
            this.costos.put(tipo, valor);
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminar(String tipo) {
        if (costos.containsKey(tipo)) {
            costos.remove(tipo);
            return true;
        }
        return false;
    }


}
