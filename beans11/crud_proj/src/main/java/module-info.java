/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

module com.mycompany.crud_proj {
    //requires javafx.controlsEmpty;
    requires javafx.controls;
    //requires javafx.graphicsEmpty;
    requires javafx.graphics;
    //requires javafx.baseEmpty;
    requires javafx.base;
    //requires javafx.fxmlEmpty;
    //requires mysql.connector.java;    
    requires javafx.fxml;
    requires java.sql; 
    
    
    opens com.mycompany.crud_proj to javafx.fxml;
    exports com.mycompany.crud_proj;
}
