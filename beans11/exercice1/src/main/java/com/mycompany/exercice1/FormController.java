/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exercice1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author 80010-92-01
 */
public class FormController implements Initializable {

    @FXML
    private Button Btn;
    @FXML
    private TextField nom;
    @FXML
    private TextField adresse;
    @FXML
    private TextField cp;
    @FXML
    private TextField ville;
    @FXML
    private TextField contact; 
    @FXML
    private Label affiche;
    @FXML
    private TextField entree;
    @FXML
    private Label er_fournis;    
    
    //def pour requtete
    PreparedStatement res;
    Connection con;
    ResultSet result;
   
 
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    // param de connexion   
    String url_db ="jdbc:mysql://localhost:3306/papyrus?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
    String login = "root";
    String mdp = "";
    
       
        try {
             // connexion db et prep requete 
            con = DriverManager.getConnection(url_db,login,mdp);           
            affiche.setText("connexion");
            affiche.setStyle("-fx-text-fill: green;");
           
        } catch (SQLException ex) {           
            affiche.setText("Erreur connexion !");
            affiche.setStyle("-fx-text-fill: red;");
        }            
    }    

    @FXML
    private void select(ActionEvent event) {
        
        // string to int le n° fournisseur
        String code = entree.getText();
              
        try {
            // exectue la requete 
            res = con.prepareStatement("SELECT * FROM fournis WHERE numfou = ?");            
            res.setString(1,code);
            result = res.executeQuery();
            
                //recup et affiche les données
                if (result.next()) {
                    // efface message erreur sur fournisseur
                    er_fournis.setText("");
                    
                    //affiche les données 
                    nom.setText(result.getString("nomfou"));
                    adresse.setText(result.getString("ruefou"));
                    cp.setText(result.getString("posfou"));
                    ville.setText(result.getString("vilfou"));
                    contact.setText(result.getString("confou"));
                }else{
                    er_fournis.setText("Fournisseur inconnu !");
                    er_fournis.setStyle("-fx-text-fill: red;");       
                }       
        } catch (SQLException ex) {            
            affiche.setText( ex.getMessage());
            affiche.setStyle("-fx-text-fill: red;");
        }           
    }  
}
