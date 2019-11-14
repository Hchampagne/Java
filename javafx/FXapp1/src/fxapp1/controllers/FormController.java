/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxapp1.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 * v1.00 14/11/2019
 * @author 80010-92-01
 */
public class FormController implements Initializable {

    @FXML
    private TextField TextField;
    @FXML
    private Button button;
    @FXML
    private Label label;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void button_click(ActionEvent event) {
        
        label.setText("Bonjour " + TextField.getText());
    }
    
}
