module com.mycompany.fxapp1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.fxapp1 to javafx.fxml;
    exports com.mycompany.fxapp1;
}