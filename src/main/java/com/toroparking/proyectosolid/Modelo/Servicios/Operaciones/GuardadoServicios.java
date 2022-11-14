package com.toroparking.proyectosolid.Modelo.Servicios.Operaciones;

import com.toroparking.proyectosolid.Modelo.ToroParking;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GuardadoServicios implements IGuardarServicioActivo, IGuardarServicioFinalizado {
    @Override
    public void guardarActivos() {
        try {
            FileOutputStream writeData;
            writeData = new FileOutputStream("ServiciosActivos.bin");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
            writeStream.writeObject(ToroParking.getInstance().getServiciosEnCurso());
            writeStream.close();
            writeData.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void guardarFinalizados() {
        try
        {
            FileOutputStream writeData;
            writeData = new FileOutputStream("ServiciosFinalizados.bin");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
            writeStream.writeObject(ToroParking.getInstance().getServiciosFinalizados());
            writeStream.close();
            writeData.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
