package com.toroparking.proyectosolid;

import com.toroparking.proyectosolid.Modelo.Configuracion.IGuardadoConfiguracion;
import com.toroparking.proyectosolid.Modelo.TipoVehiculos.TipoVehiculo;
import com.toroparking.proyectosolid.Modelo.ToroParking;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    private static Scene scene;

    public static void main(String[] args) throws IOException {
        ToroParking.getInstance();
        setScene();
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

    private static Parent loadFXML(String fxml) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Vista/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void setRoot(String fxml) throws IOException
    {
        scene.setRoot(loadFXML(fxml));
    }

    public static Scene getScene() {
        return scene;
    }
    public static void setScene() throws IOException {
        scene = new Scene(loadFXML("pantallaInicioSesion"), 600, 400);
    }
}
