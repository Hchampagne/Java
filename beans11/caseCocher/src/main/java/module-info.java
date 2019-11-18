module com.mycompany.casecocher {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.casecocher to javafx.fxml;
    exports com.mycompany.casecocher;
}