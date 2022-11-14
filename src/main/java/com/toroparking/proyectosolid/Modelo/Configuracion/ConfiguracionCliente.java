package com.toroparking.proyectosolid.Modelo.Configuracion;

import com.toroparking.proyectosolid.Modelo.TipoUsuarios.Cliente;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Optional;

@Data
public class ConfiguracionCliente implements IConfiguracionPersona, Serializable {
    private ArrayList<Cliente> clientes;

    public ConfiguracionCliente() {
        this.clientes = new ArrayList<>();
    }

    public ConfiguracionCliente(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public Optional<?> buscar(String id) {
        for (Cliente c : clientes) {
            if (c.getId().equalsIgnoreCase(id)) {
                return Optional.of(c);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean agregar(String nombre, String id, String user, String numero) {
        for (Cliente c : clientes) {
            if (c.getUsuario().equals(user)) {
                return false;
            }
        }
        Cliente cliente = new Cliente(nombre, id, numero);
        clientes.add(cliente);
        return true;
    }

    @Override
    public boolean eliminar(String id) {
        Optional<?> cliente = buscar(id);
        if (cliente.isPresent()) {
            for (int i = 0; i < clientes.size(); i++) {
                if(clientes.get(i).equals(cliente.get())) {
                    clientes.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hacerMiembro (Cliente cliente) {
        for (Cliente c : this.clientes) {
            if (c.equals(cliente)) {
                c.setMiembro(true);
                return true;
            }
        }
        return false;
    }
}
