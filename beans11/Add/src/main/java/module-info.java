module com.mycompany.add {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.add to javafx.fxml;
    exports com.mycompany.add;
}