module com.example.unicornstorage {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.unicornstorage to javafx.fxml;
    exports com.example.unicornstorage;
}