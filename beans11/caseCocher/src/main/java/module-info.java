module com.mycompany.casecocher {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires javafx.graphicsEmpty;

    opens com.mycompany.casecocher to javafx.fxml;
    exports com.mycompany.casecocher;
}