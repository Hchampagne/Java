module com.mycompany.melange {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.melange to javafx.fxml;
    exports com.mycompany.melange;
}