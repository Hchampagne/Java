/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exercice3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * FXML Controller class
 *
 * @author Doudou
 */
public class FXMLController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField cp;
    @FXML
    private TextField contact;
    @FXML
    private TextField ville;
    @FXML
    private TextField rue;
    @FXML
    private Button ajout;
    @FXML
    private Button annuler;
    @FXML
    private Label message;
    
    //def requetes
    Connection con;
    
    
    
    
    //variables connexion
    String url_db ="jdbc:mysql://localhost:3306/papyrus?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
    String login = "root";
    String mdp = "";

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //connexion data base
        try { 
            con = DriverManager.getConnection(url_db,login,mdp);      
            message.setText("Vous êtes connecté");
            message.setStyle("-fx-text-fill: green;");
        } catch (SQLException ex) {
            message.setText("Erreur de connexion");
            message.setStyle("-fx-text-fill: red;");
        }
    }    

    @FXML
    private void ajout(ActionEvent event) {
    }

    @FXML
    private void annuler(ActionEvent event) {
    }
    
}
