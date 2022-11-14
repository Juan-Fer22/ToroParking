module com.toroparking.proyectosolid {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;


    opens com.toroparking.proyectosolid to javafx.fxml;
    opens com.toroparking.proyectosolid.Controlador to javafx.fxml;
    exports com.toroparking.proyectosolid;
    exports com.toroparking.proyectosolid.Controlador;
}