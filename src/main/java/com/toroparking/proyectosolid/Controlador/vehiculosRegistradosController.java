/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.toroparking.proyectosolid.Controlador;

import com.toroparking.proyectosolid.App;
import com.toroparking.proyectosolid.Modelo.Configuracion.IGuardadoConfiguracion;
import com.toroparking.proyectosolid.Modelo.Servicios.Servicio;
import com.toroparking.proyectosolid.Modelo.TipoVehiculos.Carro;
import com.toroparking.proyectosolid.Modelo.TipoVehiculos.TipoVehiculo;
import com.toroparking.proyectosolid.Modelo.ToroParking;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
/**
 * FXML Controller class
 *
 * @author jagui
 */
public class vehiculosRegistradosController implements Initializable
{
    @FXML
    private ChoiceBox<String> choiceBoxRegistrados;
    @FXML
    private Text txtPlaca;
    @FXML
    private Text txtFechaRegistro;
    @FXML
    private Text txtCostoActual;
    @FXML
    private TextField txtFieldPlaca;
    private ArrayList<Servicio> serviciosActivos;
    private Servicio servicioSeleccionado;
    private int indiceServicioSeleccionado;
    @FXML
    private Text txtNomCliente;
    @FXML
    private Text txtCedula;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        servicioSeleccionado = null;
        indiceServicioSeleccionado = -1;
        ArrayList<Servicio> cargar = ToroParking.getInstance().getOperaciones().cargarActivos();
        ToroParking.getInstance().setServiciosEnCurso(cargar);
        serviciosActivos = ToroParking.getInstance().getServiciosEnCurso();
        ArrayList <String> strServicios = new ArrayList<>();

        for (Servicio serviciosActivo : serviciosActivos) {
            strServicios.add(serviciosActivo.toString());
        }
        
        ObservableList<String> obsListServicios = FXCollections.observableArrayList(strServicios);
        choiceBoxRegistrados.setItems(obsListServicios);
        choiceBoxRegistrados.getSelectionModel().selectedIndexProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> 
        {
            indiceServicioSeleccionado = newValue.intValue();   
            
            if(indiceServicioSeleccionado != -1)
            {
                servicioSeleccionado = serviciosActivos.get(indiceServicioSeleccionado);
                mostrarInfo(servicioSeleccionado);
            }
            
        });
    }
    
    @FXML
    private void irMenuPrincipal(ActionEvent event) throws IOException 
    {
        App.setRoot("pantallaPrincipal");
    }

    @FXML
    private void buscarPlaca(ActionEvent event) 
    {
        String placaIngresada = txtFieldPlaca.getText().toUpperCase();
        if(Pattern.matches("([A-Z]){3}([0-9]){3}", placaIngresada)||Pattern.matches("([A-Z]){3}([0-9]){2}[A-Z]", placaIngresada))
        {
            boolean encontro = false;
            for(int i = 0 ; i < serviciosActivos.size() && !encontro; i++)
            {

                if((serviciosActivos.get(i).getVehiculo().getPlaca().equals(placaIngresada)))
                {
                    encontro = true;
                    indiceServicioSeleccionado = i;
                }
            }
            if(encontro)
            {
                choiceBoxRegistrados.getSelectionModel().select(indiceServicioSeleccionado);
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Placa No Encontrada");
                alert.setHeaderText("¡Error!");
                alert.setContentText("La placa ingresada no se encuentra registrada.");
                alert.showAndWait();                  
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Placa Invalida");
            alert.setHeaderText("¡Error!");
            alert.setContentText("Se ha ingresado una placa invalida");
            alert.showAndWait();              
        }
    }

    @FXML
    private void refrescarCosto(ActionEvent event) 
    {
        if(servicioSeleccionado != null)
        {
            mostrarInfo(servicioSeleccionado);
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("No Hay Vehiculo Seleccionado");
            alert.setHeaderText("¡Revisar!");
            alert.setContentText("Seleccione o busque un vehiculo primero.");
            alert.showAndWait();    
        }
    }

    @FXML
    private void finalizarServicio(ActionEvent event) 
    {
        double costoFinal;
        if(servicioSeleccionado != null)
        {
            costoFinal = ToroParking.getInstance().getOperaciones().finalizar(indiceServicioSeleccionado);
            if (costoFinal != -1 && servicioSeleccionado.getVehiculo() instanceof Carro) {
                ToroParking.getInstance().getConfiguracionGeneral().getConfiguracionCupos().aumentarCupo(String.valueOf(TipoVehiculo.Carro));
            } else
                ToroParking.getInstance().getConfiguracionGeneral().getConfiguracionCupos().aumentarCupo(String.valueOf(TipoVehiculo.Moto));
            ToroParking.getInstance().getOperaciones().guardarFinalizados();
            IGuardadoConfiguracion.guardar(ToroParking.getInstance().getConfiguracionGeneral());
            serviciosActivos = ToroParking.getInstance().getServiciosEnCurso();
            txtCostoActual.setText("");
            txtFechaRegistro.setText("");
            txtPlaca.setText("");
            txtCedula.setText("");
            txtNomCliente.setText("");
            ArrayList <String> strServicios = new ArrayList<String>();
            for(int i = 0; i < serviciosActivos.size(); i++)
            {
                strServicios.add(serviciosActivos.get(i).toString());
            }
     
            ObservableList<String> obsListServicios = FXCollections.observableArrayList(strServicios);
            choiceBoxRegistrados.setItems(obsListServicios);      
            
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Servicio Finalizado Exitosamente");
            alert.setHeaderText("¡Felicidades!");
            alert.setContentText("El Costo Final del Servicio Fue: $" + costoFinal);
            alert.showAndWait();    
            
            servicioSeleccionado = null;
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("No Hay Vehiculo Seleccionado");
            alert.setHeaderText("¡Revisar!");
            alert.setContentText("Seleccione o busque un vehiculo primero.");
            alert.showAndWait();    
        }
    }
    
    private void mostrarInfo(Servicio seleccionado)
    {
        txtPlaca.setText(seleccionado.getVehiculo().getPlaca());
        txtFechaRegistro.setText(seleccionado.getStringFechaInicial());
        String costoActual = ""+ seleccionado.calcularCosto();
        txtCostoActual.setText(costoActual);
        txtNomCliente.setText(seleccionado.getVehiculo().getPropietario().getNombre());
        txtCedula.setText(seleccionado.getVehiculo().getPropietario().getId()+" / "+seleccionado.getVehiculo().getPropietario().getNumero());
    }


}
