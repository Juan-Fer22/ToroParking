/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.toroparking.proyectosolid.Controlador;

import com.toroparking.proyectosolid.App;
import com.toroparking.proyectosolid.Modelo.Configuracion.IGuardadoConfiguracion;
import com.toroparking.proyectosolid.Modelo.Servicios.Servicio;
import com.toroparking.proyectosolid.Modelo.TipoUsuarios.Cliente;
import com.toroparking.proyectosolid.Modelo.TipoVehiculos.TipoVehiculo;
import com.toroparking.proyectosolid.Modelo.ToroParking;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
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
public class registrarVehiculoController implements Initializable {

    @FXML
    private RadioButton radioBtnMoto;
    @FXML
    private RadioButton radioBtnCarro;
    @FXML
    private TextField txtPlaca;
    @FXML
    private TextField txtBloq0id;
    @FXML
    private TextField txtBloq1id;
    @FXML
    private TextField txtBloq2id;
    @FXML
    private TextField txtBloq3id;
    @FXML
    private Label lblNombre;
    @FXML
    private Label lblNumCelular;
    @FXML
    private Label lblCel1;
    @FXML
    private Label lblCel0;
    @FXML
    private Label lblCel2;
    @FXML
    private TextField txtFieldNomCliente;
    @FXML
    private Label lblNoExiste;
    @FXML
    private TextField txtBloq0Celular;
    @FXML
    private TextField txtBloq1Celular;
    @FXML
    private TextField txtBloq2Celular;
    @FXML
    private TextField txtBloq3Celular;
    @FXML
    private Text txtCuposAuto;
    @FXML
    private Text txtCuposMoto;

    private ArrayList<Integer> cupos;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        actualizarCupos();
    }

    @FXML
    private void irMenuPrincipal(ActionEvent event) throws IOException {
        App.setRoot("pantallaPrincipal");
    }

    public void actualizarCupos() {
        txtCuposAuto.setText("Automovil: " + ToroParking.getInstance().getConfiguracionGeneral().getConfiguracionCupos().obtenerCupo(String.valueOf(TipoVehiculo.Carro)));
        txtCuposMoto.setText("Motocicleta: " + ToroParking.getInstance().getConfiguracionGeneral().getConfiguracionCupos().obtenerCupo(String.valueOf(TipoVehiculo.Moto)));
    }

    @FXML
    private void radioBtnMotoCheck(ActionEvent event) throws IOException {
        if (radioBtnMoto.isSelected()) {
            radioBtnCarro.setSelected(false);
        } else if (!radioBtnMoto.isSelected() && !radioBtnCarro.isSelected()) {
            radioBtnMoto.setSelected(true);
        }
    }

    @FXML
    private void radioBtnCarroCheck(ActionEvent event) throws IOException {
        if (radioBtnCarro.isSelected()) {
            radioBtnMoto.setSelected(false);
        } else if (!radioBtnMoto.isSelected() && !radioBtnCarro.isSelected()) {
            radioBtnCarro.setSelected(true);
        }
    }

    @FXML
    private void registrarVehiculo(ActionEvent event) throws IOException {
        String placaIngresada = txtPlaca.getText().toUpperCase();
        String cedulaIngresada = "";
        String celularIngresado = "";
        String nombreIngresado;
        Cliente clienteServicio;
        if (!txtBloq0id.getText().equals("")) {
            cedulaIngresada += txtBloq0id.getText() + "." + txtBloq1id.getText() + "." + txtBloq2id.getText() + "." + txtBloq3id.getText();
        } else {
            cedulaIngresada += txtBloq1id.getText() + "." + txtBloq2id.getText() + "." + txtBloq3id.getText();
        }

        if (lblNombre.isVisible() && ToroParking.getInstance().getConfiguracionGeneral().getClientes().buscar(cedulaIngresada).isEmpty()) {
            nombreIngresado = txtFieldNomCliente.getText();
            celularIngresado += "+" + txtBloq0Celular.getText() + "-" + txtBloq1Celular.getText() + "-" + txtBloq2Celular.getText() + "-" + txtBloq3Celular.getText();
            try {
                ToroParking.getInstance().getConfiguracionGeneral().getClientes().agregar(nombreIngresado, cedulaIngresada, null, celularIngresado);
                IGuardadoConfiguracion.guardar(ToroParking.getInstance().getConfiguracionGeneral());
            } catch (Exception e) {
                if (e.getMessage().equals("Formato Cedula Incorrecto")) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Cedula Invalida");
                    alert.setHeaderText("¡Error!");
                    alert.setContentText("Se ha ingresado un numero de cedula invalido");
                    alert.showAndWait();
                } else if (e.getMessage().equals("Formato Numero Contacto Incorrecto")) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Numero de Contacto Invalido");
                    alert.setHeaderText("¡Error!");
                    alert.setContentText("Se ha ingresado un numero de celular invalido");
                    alert.showAndWait();
                }
            }
        }

        if (ToroParking.getInstance().getConfiguracionGeneral().getClientes().buscar(cedulaIngresada).isEmpty()) {
            lblNombre.setVisible(true);
            txtFieldNomCliente.setVisible(true);

            lblNumCelular.setVisible(true);
            lblCel0.setVisible(true);
            lblCel1.setVisible(true);
            lblCel2.setVisible(true);

            txtBloq0Celular.setVisible(true);
            txtBloq1Celular.setVisible(true);
            txtBloq2Celular.setVisible(true);
            txtBloq3Celular.setVisible(true);

            lblNoExiste.setVisible(true);

        } else {
            clienteServicio = (Cliente) ToroParking.getInstance().getConfiguracionGeneral().getClientes().buscar(cedulaIngresada).get();

            if (radioBtnCarro.isSelected()) {
                if (Pattern.matches("([A-Z]){3}([0-9]){3}", placaIngresada)) {
                    if (ToroParking.getInstance().getConfiguracionGeneral().getConfiguracionCupos().obtenerCupo(String.valueOf(TipoVehiculo.Carro)) > 0) {
                        if (registrarVehiculo(placaIngresada, String.valueOf(TipoVehiculo.Carro), clienteServicio)) {
                            ToroParking.getInstance().getOperaciones().guardarActivos();
                            ToroParking.getInstance().getConfiguracionGeneral().getConfiguracionCupos().reducirCupo(String.valueOf(TipoVehiculo.Carro));
                            IGuardadoConfiguracion.guardar(ToroParking.getInstance().getConfiguracionGeneral());
                            irMenuPrincipal(event);
                        }
                    } else {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("No hay cupo para automovil");
                        alert.setHeaderText("¡Error!");
                        alert.setContentText("No se cuenta con espacio para estacionar el vehiculo");
                        alert.showAndWait();
                    }
                } else {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Placa Invalida");
                    alert.setHeaderText("¡Error!");
                    alert.setContentText("Se ha ingresado una placa invalida");
                    alert.showAndWait();
                }
            } else {
                if (Pattern.matches("([A-Z]){3}([0-9]){2}[A-Z]", placaIngresada)) {
                    if (ToroParking.getInstance().getConfiguracionGeneral().getConfiguracionCupos().obtenerCupo(String.valueOf(TipoVehiculo.Moto)) > 0) {
                        if (registrarVehiculo(placaIngresada, String.valueOf(TipoVehiculo.Moto), clienteServicio)) {
                            ToroParking.getInstance().getConfiguracionGeneral().getConfiguracionCupos().reducirCupo(String.valueOf(TipoVehiculo.Moto));
                            ToroParking.getInstance().getOperaciones().guardarActivos();
                            IGuardadoConfiguracion.guardar(ToroParking.getInstance().getConfiguracionGeneral());
                            irMenuPrincipal(event);
                        }
                    } else {
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setTitle("No hay cupo para motocicleta");
                        alert.setHeaderText("¡Error!");
                        alert.setContentText("No se cuenta con espacio para estacionar el vehiculo");
                        alert.showAndWait();
                    }

                } else {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Placa Invalida");
                    alert.setHeaderText("¡Error!");
                    alert.setContentText("Se ha ingresado una placa invalida");
                    alert.showAndWait();
                }
            }
        }


    }

    private boolean registrarVehiculo(String pPlaca, String vehiculo, Cliente pCliente) {
        boolean respuesta = false;
        Servicio nuevo = ToroParking.getInstance().getOperaciones().crear(vehiculo, pPlaca);
        nuevo.getVehiculo().setPropietario(pCliente);
        if (ToroParking.getInstance().getOperaciones().agregar(nuevo)) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Registro Exitoso");
            alert.setHeaderText("¡Felicidades!");
            alert.setContentText("Se ha registrado el servicio exitosamente");
            alert.showAndWait();
            respuesta = true;

        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Placa Previamente Registrada");
            alert.setHeaderText("¡Revisar!");
            alert.setContentText("Se ha ingresado una placa que ya se encuentra registrada.");
            alert.showAndWait();
        }

        return respuesta;
    }

}
