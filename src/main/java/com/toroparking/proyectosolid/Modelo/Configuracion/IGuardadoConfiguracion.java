package com.toroparking.proyectosolid.Modelo.Configuracion;

import java.io.*;

public interface IGuardadoConfiguracion {
    public static boolean guardar(ConfiguracionGeneral configuracion) {
        try
        {
            FileOutputStream writeData;
            writeData = new FileOutputStream("Config.bin");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(configuracion);
            writeStream.flush();
            writeStream.close();
            writeData.close();
            return true;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public static ConfiguracionGeneral cargar() {
        ConfiguracionGeneral configuracion = null;
        try {
            FileInputStream readData = new FileInputStream("Config.bin");
            ObjectInputStream readStream = new ObjectInputStream(readData);
            configuracion = (ConfiguracionGeneral) readStream.readObject();
            readStream.close();
            readData.close();
        } catch (IOException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return configuracion;
    }
}
