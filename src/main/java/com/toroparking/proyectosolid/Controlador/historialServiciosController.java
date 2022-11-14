/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.toroparking.proyectosolid.Controlador;

import com.toroparking.proyectosolid.App;
import com.toroparking.proyectosolid.Modelo.Servicios.Servicio;
import com.toroparking.proyectosolid.Modelo.ToroParking;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
/**
 * FXML Controller class
 *
 * @author jagui
 */
public class historialServiciosController implements Initializable
{
    @FXML
    private TextArea txtHistorial;
    
    private ArrayList<Servicio> serviciosFinalizados;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(txtHistorial);
        scrollPane.setFitToWidth(true);
        ArrayList<Servicio> cargar = ToroParking.getInstance().getOperaciones().cargarFinalizados();
        ToroParking.getInstance().setServiciosFinalizados(cargar);
        serviciosFinalizados = ToroParking.getInstance().getServiciosFinalizados();
        String historial="";
        for (Servicio serviciosFinalizado : serviciosFinalizados) {
            historial += serviciosFinalizado.toString() + "\n\n";
        }
        txtHistorial.setText(historial);
    }
    
    @FXML
    private void irMenuPrincipal(ActionEvent event) throws IOException 
    {
        App.setRoot("pantallaPrincipal");
    }
    
}
