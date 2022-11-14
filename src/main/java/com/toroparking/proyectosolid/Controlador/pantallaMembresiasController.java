/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.toroparking.proyectosolid.Controlador;


import com.toroparking.proyectosolid.App;
import com.toroparking.proyectosolid.Modelo.Configuracion.ConfiguracionCliente;
import com.toroparking.proyectosolid.Modelo.Configuracion.IGuardadoConfiguracion;
import com.toroparking.proyectosolid.Modelo.TipoUsuarios.Cliente;
import com.toroparking.proyectosolid.Modelo.ToroParking;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
/**
 * FXML Controller class
 *
 * @author jagui
 */
public class pantallaMembresiasController implements Initializable
{
    private ArrayList<Cliente> clientes;
    private Cliente clienteSeleccionado;
    private int indiceClienteSeleccionado;
    
    @FXML
    private ChoiceBox<String> choiceBoxClientes;
    @FXML
    private Text txtNombre;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        clienteSeleccionado = null;
        indiceClienteSeleccionado = -1;

        clientes = ((ConfiguracionCliente) ToroParking.getInstance().getConfiguracionGeneral().getClientes()).getClientes();
        ArrayList <String> strClientes = new ArrayList<String>();
        
        for(int i = 0; i < clientes.size(); i++)
        {
            strClientes.add(clientes.get(i).toStr2());
        }
        
        ObservableList<String> obsListClientes = FXCollections.observableArrayList(strClientes);
        choiceBoxClientes.setItems(obsListClientes);
        choiceBoxClientes.getSelectionModel().selectedIndexProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> 
        {
            indiceClienteSeleccionado = newValue.intValue();   
            
            if(indiceClienteSeleccionado != -1)
            {
                clienteSeleccionado = clientes.get(indiceClienteSeleccionado);
                mostrarInfo(clienteSeleccionado);
            }
            
        });
    }
    
    @FXML
    private void irMenuPrincipal(ActionEvent event) throws IOException 
    {
        App.setRoot("pantallaPrincipal");
    }

    
    private void mostrarInfo(Cliente seleccionado)
    {
        txtNombre.setText(seleccionado.getNombre());
    }


    @FXML
    private void eliminarCliente(ActionEvent event) 
    {
        if(clienteSeleccionado != null)
        {
            ToroParking.getInstance().getConfiguracionGeneral().getClientes().eliminar(clienteSeleccionado.getId());
            txtNombre.setText("");
            clientes = ((ConfiguracionCliente) ToroParking.getInstance().getConfiguracionGeneral().getClientes()).getClientes();
            IGuardadoConfiguracion.guardar(ToroParking.getInstance().getConfiguracionGeneral());

            ArrayList <String> strClientes = new ArrayList<String>();
            for(int i = 0; i < clientes.size(); i++)
            {
                strClientes.add(clientes.get(i).toStr2());
            }

            ObservableList<String> obsListClientes = FXCollections.observableArrayList(strClientes);
            choiceBoxClientes.setItems(obsListClientes);      

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Cliente Eliminado");
            alert.setHeaderText("¡Felicidades!");
            alert.setContentText("La cuenta del cliente llamado \"" + clienteSeleccionado.getNombre()+ "\" ha sido eliminada");
            alert.showAndWait();                
            clienteSeleccionado = null;               
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("No Hay Cliente Seleccionado");
            alert.setHeaderText("¡Revisar!");
            alert.setContentText("Seleccione un cliente para modificar la informacion.");
            alert.showAndWait();    
        }         
    }


    @FXML
    private void toggleMiembro(ActionEvent event)
    {
        boolean yaEs = false;
        if(clienteSeleccionado != null)
        {
            if(!clienteSeleccionado.isMiembro())
            {
                ((ConfiguracionCliente) ToroParking.getInstance().getConfiguracionGeneral().getClientes()).hacerMiembro(clienteSeleccionado);
            } else
                yaEs = true;
                                      
            txtNombre.setText("");
            clientes = ((ConfiguracionCliente) ToroParking.getInstance().getConfiguracionGeneral().getClientes()).getClientes();
            IGuardadoConfiguracion.guardar(ToroParking.getInstance().getConfiguracionGeneral());

            ArrayList <String> strClientes = new ArrayList<String>();
            for (Cliente cliente : clientes) {
                strClientes.add(cliente.toStr2());
            }

            ObservableList<String> obsListClientes = FXCollections.observableArrayList(strClientes);
            choiceBoxClientes.setItems(obsListClientes);      

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            if (!yaEs) {
                alert.setTitle("Estado de Membresia Cambiado");
                alert.setHeaderText("¡Felicidades!");
                alert.setContentText("La cuenta del cliente llamado \"" + clienteSeleccionado.getNombre()+"\" ha cambiado su estado de membresia");
                alert.showAndWait();
            } else {
                alert.setTitle("El cliente ya es miembro!");
                alert.setHeaderText("¡Atencion!");
                alert.setContentText("La cuenta del cliente llamado \"" + clienteSeleccionado.getNombre()+ "\" ya tiene una membresia");
                alert.showAndWait();
            }

            clienteSeleccionado = null;     
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("No Hay Cliente Seleccionado");
            alert.setHeaderText("¡Revisar!");
            alert.setContentText("Seleccione un cliente para modificar la informacion.");
            alert.showAndWait();    
        }                 
    }

}
