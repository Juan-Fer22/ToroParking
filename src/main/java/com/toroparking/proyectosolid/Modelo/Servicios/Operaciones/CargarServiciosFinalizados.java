package com.toroparking.proyectosolid.Modelo.Servicios.Operaciones;

import com.toroparking.proyectosolid.Modelo.Servicios.Servicio;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class CargarServiciosFinalizados implements ICargarServicios{
    public CargarServiciosFinalizados() {
    }

    @Override
    public ArrayList<Servicio> cargar() {
        ArrayList<Servicio> serviciosFinalizados = new ArrayList<>();
        try
        {
            FileInputStream readData = new FileInputStream("ServiciosFinalizados.bin");
            ObjectInputStream readStream = new ObjectInputStream(readData);
            serviciosFinalizados = (ArrayList<Servicio>) readStream.readObject();
            readStream.close();
            readData.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return serviciosFinalizados;
    }
}
