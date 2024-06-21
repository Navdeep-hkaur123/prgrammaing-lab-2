module com.example.csd214lab {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires java.sql;

    opens com.example.csd214lab to javafx.fxml;
    exports com.example.csd214lab;
}