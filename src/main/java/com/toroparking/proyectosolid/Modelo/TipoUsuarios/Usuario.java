package com.toroparking.proyectosolid.Modelo.TipoUsuarios;

import lombok.Data;

import java.io.Serializable;
import java.util.regex.Pattern;

@Data
public class Usuario implements Serializable {
    protected String nombre;
    protected String id;
    protected String usuario;
    protected String password;
    protected String numero;

    public Usuario() {
        this.usuario = "";
        this.password = "";
        this.nombre = "";
        this.id = "";
        this.numero = "";
    }

    public Usuario(String nombre, String id, String usuario, String password) {
        this.nombre = nombre;
        this.id = id;
        this.usuario = usuario;
        this.password = password;
    }

    public Usuario(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public Usuario(String nombre, String id, String numero) {
        this.nombre = nombre;
        this.id = id;
        this.numero = numero;
    }

    public void setID (String id) {
        if(Pattern.matches("([0-9]{1}\\.)?([0-9]{1,3}\\.){2}[0-9]{3}", id))
            this.id = id;
    }

    public void setNumero (String numero) {
        if(Pattern.matches("\\+[0-9]{2,3}-([0-9]{3}-){2}[0-9]{4}", numero))
            this.numero = numero;
    }
}
