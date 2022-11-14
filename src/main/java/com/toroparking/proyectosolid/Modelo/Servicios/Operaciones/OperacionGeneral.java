package com.toroparking.proyectosolid.Modelo.Servicios.Operaciones;

import com.toroparking.proyectosolid.Modelo.Servicios.ITipoServicio;
import com.toroparking.proyectosolid.Modelo.Servicios.Servicio;
import com.toroparking.proyectosolid.Modelo.Servicios.ServicioFinalizado;
import lombok.Data;

import java.util.ArrayList;

public class OperacionGeneral {
    private IAgregarServicio agregarServicio;
    private IFinalizarServicio finalizarServicio;
    private  ICrearServicio crearServicio;
    private IBuscarServicio buscarServicio;
    private GuardadoServicios guardar;
    private ICargarServicios cargarActivos;
    private  ICargarServicios cargarFinalizados;

    public OperacionGeneral() {
        this.agregarServicio = new AgregarServicio();
        this.finalizarServicio = new FinalizarServicio();
        this.guardar = new GuardadoServicios();
        this.crearServicio = new CrearServicio();
        this.buscarServicio = new BuscarServicio();
        this.cargarActivos = new CargarServiciosActivos();
        this.cargarFinalizados = new CargarServiciosFinalizados();
    }

    public OperacionGeneral(IAgregarServicio agregarServicio, IFinalizarServicio finalizarServicio, GuardadoServicios guardar, ICrearServicio crearServicio, IBuscarServicio buscarServicio, ICargarServicios cargarActivos, ICargarServicios cargarFinalizados) {
        this.agregarServicio = agregarServicio;
        this.finalizarServicio = finalizarServicio;
        this.guardar = guardar;
        this.crearServicio = crearServicio;
        this.buscarServicio = buscarServicio;
        this.cargarActivos = cargarActivos;
        this.cargarFinalizados = cargarFinalizados;
    }

    public int buscar (Servicio servicio) {
        return buscarServicio.buscarServicio(servicio);
    }

    public Servicio crear (String vehiculo, String placa) {
        return crearServicio.crearServicio(vehiculo, placa);
    }

    public boolean agregar(Servicio servicio) {
        boolean respuesta = agregarServicio.agregarServicio(servicio);
        guardarActivos();
        return respuesta;
    }

    public double finalizar (int indice) {
        double respuesta = finalizarServicio.finalizarServicio(indice);
        guardarFinalizados();
        guardarActivos();
        return respuesta;
    }

    public void guardarActivos () {
        guardar.guardarActivos();
    }

    public void guardarFinalizados () {
        guardar.guardarFinalizados();
    }

    public ArrayList<Servicio> cargarActivos (){
        return this.cargarActivos.cargar();
    }

    public ArrayList<Servicio> cargarFinalizados () {
        return this.cargarFinalizados.cargar();
    }
}
