package com.toroparking.proyectosolid.Controlador;

import com.toroparking.proyectosolid.App;
import com.toroparking.proyectosolid.Modelo.ToroParking;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PantallaPrincipalController implements Initializable {
    @FXML
    private Text txtFecha;

    Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(1),
                    e ->
                    {
                        txtFecha.setText(ToroParking.getInstance().getConfiguracionGeneral().getFecha());
                    }));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String fechaActual = ToroParking.getInstance().getConfiguracionGeneral().getFecha();
        txtFecha.setText(fechaActual);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    @FXML
    private void irRegistrarVehiculo() throws IOException {
        App.setRoot("registrarVehiculo");
    }

    @FXML
    private void irVehiculosRegistrados() throws IOException {
        App.setRoot("vehiculosRegistrados");
    }

    @FXML
    private void irHistorialServicios() throws IOException {
        App.setRoot("historialServicios");
    }

    @FXML
    private void irConfiguraciones(ActionEvent event) throws IOException {
        App.setRoot("pantallaConfiguraciones");
    }

    @FXML
    private void cerrarSesion(ActionEvent event) throws IOException {
        //ToroParking.getInstance().cerrarSesion();
        App.setRoot("pantallaInicioSesion");
    }

    @FXML
    private void irClientesRegistrados(ActionEvent event) throws IOException {
        App.setRoot("pantallaClientesRegistrados");
    }

    @FXML
    private void irPantallaMembresias(ActionEvent event) throws IOException {
        App.setRoot("pantallaMembresias");
    }
}
