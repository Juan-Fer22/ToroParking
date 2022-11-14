package com.toroparking.proyectosolid.Modelo.Servicios.Operaciones;

import com.toroparking.proyectosolid.Modelo.Servicios.Servicio;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class CargarServiciosActivos implements ICargarServicios{
    public CargarServiciosActivos() {
    }

    @Override
    public ArrayList<Servicio> cargar() {
        ArrayList<Servicio> serviciosActivos = new ArrayList<>();
        try
        {
            FileInputStream readData = new FileInputStream("ServiciosActivos.bin");
            ObjectInputStream readStream = new ObjectInputStream(readData);
            serviciosActivos = (ArrayList<Servicio>) readStream.readObject();
            readStream.close();
            readData.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return serviciosActivos;
    }
}
