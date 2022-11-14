/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.toroparking.proyectosolid.Controlador;


import com.toroparking.proyectosolid.App;
import com.toroparking.proyectosolid.Modelo.Configuracion.ConfiguracionCliente;
import com.toroparking.proyectosolid.Modelo.TipoUsuarios.Cliente;
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
public class clientesRegistradosController implements Initializable
{    
    private ArrayList<Cliente> clientes;
    @FXML
    private TextArea txtClientes;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(txtClientes);
        scrollPane.setFitToWidth(true);

        clientes = ((ConfiguracionCliente)ToroParking.getInstance().getConfiguracionGeneral().getClientes()).getClientes();
        String clientesStr="";
        for(int i = 0; i < clientes.size(); i++)
        {
            clientesStr += clientes.get(i).toString() + "\n\n";
        }
        txtClientes.setText(clientesStr);
    }
    
    @FXML
    private void irMenuPrincipal(ActionEvent event) throws IOException 
    {
        App.setRoot("pantallaPrincipal");
    }
    
}
