package com.toroparking.proyectosolid.Modelo.Configuracion;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ConfiguracionCupos implements IConfiguracionCupos, Serializable {
    private Map <String, Integer> cupos;

    public ConfiguracionCupos() {
        this.cupos = new HashMap<>();
    }

    public ConfiguracionCupos(Map<String, Integer> cupos) {
        this.cupos = cupos;
    }


    @Override
    public boolean aumentarCupo(String tipo) {
        if (cupos.containsKey(tipo)) {
            int cupo = cupos.get(tipo);
            cupo++;
            cupos.put(tipo, cupo);
            return true;
        }
        return false;
    }

    @Override
    public boolean reducirCupo(String tipo) {
        if (cupos.containsKey(tipo) && cupos.get(tipo) > 0) {
            int cupo = cupos.get(tipo);
            cupo--;
            cupos.put(tipo, cupo);
            return true;
        }
        return false;
    }

    @Override
    public int obtenerCupo(String tipo) {
        if (cupos.containsKey(tipo)) {
            return cupos.get(tipo);
        }
        return -1;
    }

    @Override
    public boolean agregarCupo(String tipo, int cupo) {
        if (!cupos.containsKey(tipo)) {
            cupos.put(tipo, cupo);
            return true;
        }
        return false;
    }
}
