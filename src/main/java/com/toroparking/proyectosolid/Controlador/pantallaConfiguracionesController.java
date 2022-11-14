/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.toroparking.proyectosolid.Controlador;

import com.toroparking.proyectosolid.App;
import com.toroparking.proyectosolid.Modelo.Configuracion.IGuardadoConfiguracion;
import com.toroparking.proyectosolid.Modelo.TipoVehiculos.TipoVehiculo;
import com.toroparking.proyectosolid.Modelo.ToroParking;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

/**
 * FXML Controller class
 *
 * @author jagui
 */
public class pantallaConfiguracionesController implements Initializable {
    @FXML
    private TextField txtFieldCarro;
    @FXML
    private TextField txtFieldMoto;
    @FXML
    private TextField txtFieldCupoCarro;
    @FXML
    private TextField txtFieldCupoMoto;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        String costoMoto = "" + ToroParking.getInstance().getConfiguracionGeneral().getCostos().buscar(String.valueOf(TipoVehiculo.Moto)).get();
        String costoCarro = "" + ToroParking.getInstance().getConfiguracionGeneral().getCostos().buscar(String.valueOf(TipoVehiculo.Carro)).get();
        String capacidadMoto = "" + ToroParking.getInstance().getConfiguracionGeneral().getConfiguracionCapacidades().obtenerCapacidad(String.valueOf(TipoVehiculo.Moto));
        String capacidadCarro = "" + ToroParking.getInstance().getConfiguracionGeneral().getConfiguracionCapacidades().obtenerCapacidad(String.valueOf(TipoVehiculo.Carro));


        txtFieldCarro.setText(costoCarro);
        txtFieldMoto.setText(costoMoto);

        txtFieldCupoMoto.setText(capacidadMoto);
        txtFieldCupoCarro.setText(capacidadCarro);
    }

    @FXML
    private void irMenuPrincipal(ActionEvent event) throws IOException {
        App.setRoot("pantallaPrincipal");
    }

    @FXML
    private void irAdministradores(ActionEvent event) throws IOException {
        App.setRoot("pantallaAdministradores");
    }

    @FXML
    private void cambiarCostoMoto(ActionEvent event) {
        String costoLeido = txtFieldMoto.getText();

        if (Pattern.matches("([0-9])*.{0,1}([0-9])*", costoLeido)) {
            if (ToroParking.getInstance().getConfiguracionGeneral().getCostos().modificar(String.valueOf(TipoVehiculo.Moto), Double.parseDouble(costoLeido))) {
                IGuardadoConfiguracion.guardar(ToroParking.getInstance().getConfiguracionGeneral());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Costo Cambiado Exitosamente");
                alert.setHeaderText("¡Felicidades!");
                alert.setContentText("Se ha cambiado el costo del minuto para motocicletas.");
                alert.showAndWait();
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Costo Ingresado Invalido");
            alert.setHeaderText("¡Revisar!");
            alert.setContentText("Se ha ingresado un costo invalido.");
            alert.showAndWait();
        }
    }

    @FXML
    private void cambiarCostoCarro(ActionEvent event) {
        String costoLeido = txtFieldCarro.getText();
        if (Pattern.matches("([0-9])*.{0,1}([0-9])*", costoLeido)) {
            if (ToroParking.getInstance().getConfiguracionGeneral().getCostos().modificar(String.valueOf(TipoVehiculo.Carro), Double.parseDouble(costoLeido))) {
                IGuardadoConfiguracion.guardar(ToroParking.getInstance().getConfiguracionGeneral());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Costo Cambiado Exitosamente");
                alert.setHeaderText("¡Felicidades!");
                alert.setContentText("Se ha cambiado el costo del minuto para automoviles.");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Costo Ingresado Invalido");
            alert.setHeaderText("¡Revisar!");
            alert.setContentText("Se ha ingresado un costo invalido.");
            alert.showAndWait();
        }
    }


    @FXML
    private void cambiarCapacidadCarro(ActionEvent event) {
        String capacidadLeida = txtFieldCupoCarro.getText();
        if (Pattern.matches("[1-9][0-9]{0,3}", capacidadLeida)) {
            if (ToroParking.getInstance().getConfiguracionGeneral().getConfiguracionCapacidades().obtenerCapacidad(String.valueOf(TipoVehiculo.Carro)) - ToroParking.getInstance().getConfiguracionGeneral().getConfiguracionCupos().obtenerCupo(String.valueOf(TipoVehiculo.Carro)) <= Integer.parseInt(capacidadLeida)) {
                if (ToroParking.getInstance().getConfiguracionGeneral().getConfiguracionCapacidades().modificarCapacidad(String.valueOf(TipoVehiculo.Carro), Integer.parseInt(capacidadLeida))) {
                    IGuardadoConfiguracion.guardar(ToroParking.getInstance().getConfiguracionGeneral());
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Capacidad Cambiada Exitosamente");
                    alert.setHeaderText("¡Felicidades!");
                    alert.setContentText("Se ha cambiado la capacidad para automoviles.");
                    alert.showAndWait();
                }

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Capacidad Ingresada Invalida");
                alert.setHeaderText("¡Revisar!");
                alert.setContentText("No se puede reducir la cantidad de cupos a una cantidad menor servicios activos");
                alert.showAndWait();
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Capacidad Ingresada Invalida");
            alert.setHeaderText("¡Revisar!");
            alert.setContentText("Se ha ingresado una capacidad invalida.");
            alert.showAndWait();
        }
    }

    @FXML
    private void cambiarCapacidadMoto(ActionEvent event) {
        String capacidadLeida = txtFieldCupoMoto.getText();
        if (Pattern.matches("[1-9][0-9]{0,3}", capacidadLeida)) {
            if (ToroParking.getInstance().getConfiguracionGeneral().getConfiguracionCapacidades().obtenerCapacidad(String.valueOf(TipoVehiculo.Moto)) - ToroParking.getInstance().getConfiguracionGeneral().getConfiguracionCupos().obtenerCupo(String.valueOf(TipoVehiculo.Moto)) <= Integer.parseInt(capacidadLeida)) {
                if (ToroParking.getInstance().getConfiguracionGeneral().getConfiguracionCapacidades().modificarCapacidad(String.valueOf(TipoVehiculo.Moto), Integer.parseInt(capacidadLeida))) {
                    IGuardadoConfiguracion.guardar(ToroParking.getInstance().getConfiguracionGeneral());
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Capacidad Cambiada Exitosamente");
                    alert.setHeaderText("¡Felicidades!");
                    alert.setContentText("Se ha cambiado la capacidad para motos.");
                    alert.showAndWait();
                }

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Capacidad Ingresada Invalida");
                alert.setHeaderText("¡Revisar!");
                alert.setContentText("No se puede reducir la cantidad de cupos a una cantidad menor servicios activos");
                alert.showAndWait();
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Capacidad Ingresada Invalida");
            alert.setHeaderText("¡Revisar!");
            alert.setContentText("Se ha ingresado una capacidad invalida.");
            alert.showAndWait();
        }
    }

}
