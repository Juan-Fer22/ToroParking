/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.toroparking.proyectosolid.Controlador;

import com.toroparking.proyectosolid.App;
import com.toroparking.proyectosolid.Modelo.Configuracion.ConfiguracionAdmin;
import com.toroparking.proyectosolid.Modelo.ToroParking;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * FXML Controller class
 *
 * @author jagui
 */
public class inicioSesionController {
    @FXML
    private Button btnIngresar;
    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtPassword;

    @FXML
    private void iniciarSesion() throws IOException {
        if (((ConfiguracionAdmin) ToroParking.getInstance().getConfiguracionGeneral().getAdministradores()).iniciarSesion(txtUsuario.getText(), txtPassword.getText())) {
            App.setRoot("pantallaPrincipal");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Credenciales Incorrectas");
            alert.setHeaderText("¡Revisar!");
            alert.setContentText("¡No se encuentran los credenciales ingresados!");
            alert.showAndWait();
        }
    }
}
