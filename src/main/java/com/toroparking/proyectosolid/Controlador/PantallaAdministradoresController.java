package com.toroparking.proyectosolid.Controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.toroparking.proyectosolid.App;
import com.toroparking.proyectosolid.Modelo.Configuracion.ConfiguracionAdmin;
import com.toroparking.proyectosolid.Modelo.Configuracion.IGuardadoConfiguracion;
import com.toroparking.proyectosolid.Modelo.TipoUsuarios.Administrador;
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

/**
 * FXML Controller class
 *
 * @author jagui
 */
public class PantallaAdministradoresController implements Initializable {
    private ArrayList<Administrador> admins;
    private Administrador adminSeleccionado;
    private int indiceAdminSeleccionado;
    @FXML
    private ChoiceBox<String> choiceBoxAdministradores;
    @FXML
    private Text txtUsuario;
    @FXML
    private TextField txtFieldPass;
    @FXML
    private TextField txtFieldUser;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        adminSeleccionado = null;
        indiceAdminSeleccionado = -1;
        admins = ((ConfiguracionAdmin) ToroParking.getInstance().getConfiguracionGeneral().getAdministradores()).getAdministradores();
        ArrayList<String> strAdmins = new ArrayList<String>();

        for (int i = 0; i < admins.size(); i++) {
            strAdmins.add(admins.get(i).toString());
        }

        ObservableList<String> obsListServicios = FXCollections.observableArrayList(strAdmins);
        choiceBoxAdministradores.setItems(obsListServicios);
        choiceBoxAdministradores.getSelectionModel().selectedIndexProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) ->
        {
            indiceAdminSeleccionado = newValue.intValue();

            if (indiceAdminSeleccionado != -1) {
                adminSeleccionado = admins.get(indiceAdminSeleccionado);
                mostrarInfo(adminSeleccionado);
            }

        });
    }

    @FXML
    private void irMenuPrincipal(ActionEvent event) throws IOException {
        App.setRoot("pantallaPrincipal");
    }


    private void mostrarInfo(Administrador seleccionado) {
        txtUsuario.setText(seleccionado.getUsuario());
    }

    @FXML
    private void eliminarAdmin(ActionEvent event) {


        if (adminSeleccionado != null) {

            if (ToroParking.getInstance().getConfiguracionGeneral().getAdministradores().eliminar(adminSeleccionado.getId())) {

                txtUsuario.setText("");
                admins = ((ConfiguracionAdmin) ToroParking.getInstance().getConfiguracionGeneral().getAdministradores()).getAdministradores();
                IGuardadoConfiguracion.guardar(ToroParking.getInstance().getConfiguracionGeneral());

                ArrayList<String> strAdmins = new ArrayList<String>();
                for (int i = 0; i < admins.size(); i++) {
                    strAdmins.add(admins.get(i).toString());
                }

                ObservableList<String> obsListAdmins = FXCollections.observableArrayList(strAdmins);
                choiceBoxAdministradores.setItems(obsListAdmins);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Administrador Eliminado");
                alert.setHeaderText("¡Felicidades!");
                alert.setContentText("La cuenta de administrador con usuario \"" + adminSeleccionado.getUsuario() + "\" ha sido eliminada");
                alert.showAndWait();
                adminSeleccionado = null;
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("¡Revisar!");
                alert.setContentText("¡No se puede eliminar la cuenta de la cual se encuentra conectado!.");
                alert.showAndWait();
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("No Hay Administrador Seleccionado");
            alert.setHeaderText("¡Revisar!");
            alert.setContentText("Seleccione un administrador para eliminar la cuenta.");
            alert.showAndWait();
        }

    }

    @FXML
    private void agregarAdmin(ActionEvent event) {
        String usuarioIngresado = txtFieldUser.getText();
        String passIngresado = txtFieldPass.getText();

        if (ToroParking.getInstance().getConfiguracionGeneral().getAdministradores().agregar(null, null, usuarioIngresado, passIngresado))
        {
            IGuardadoConfiguracion.guardar(ToroParking.getInstance().getConfiguracionGeneral());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Registro Exitoso");
            alert.setHeaderText("¡Felicidades!");
            alert.setContentText("Se ha creado la nueva cuenta de administrador");
            alert.showAndWait();
            txtFieldUser.setText("");
            txtFieldPass.setText("");
            admins = ((ConfiguracionAdmin) ToroParking.getInstance().getConfiguracionGeneral().getAdministradores()).getAdministradores();

            ArrayList<String> strAdmins = new ArrayList<String>();
            for (int i = 0; i < admins.size(); i++) {
                strAdmins.add(admins.get(i).toString());
            }

            ObservableList<String> obsListAdmins = FXCollections.observableArrayList(strAdmins);
            choiceBoxAdministradores.setItems(obsListAdmins);
        } else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Usuario de administrador duplicado");
            alert.setHeaderText("¡Revisar!");
            alert.setContentText("¡Se ha ingresado un nombre de usuario ya existente!.");
            alert.showAndWait();
        }
    }

    @FXML
    private void irConfiguraciones(ActionEvent event) throws IOException {
        App.setRoot("pantallaConfiguraciones");
    }
}
