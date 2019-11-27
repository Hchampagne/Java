/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exercice2;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;



/**
 * FXML Controller class
 *
 * @author 80010-92-01
 */
public class ViewController implements Initializable {

    @FXML
    private TextArea affiche;
    @FXML
    private ComboBox<String> choix;
    @FXML
    private Label label;
    
    
    Statement res;
    PreparedStatement cmd;
    PreparedStatement fourn;
    Connection con;
    ResultSet result;
    ResultSet commande;
    ResultSet fournisseur;
    
    String url_db ="jdbc:mysql://localhost:3306/papyrus?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
    String login = "root";
    String mdp = "";
    
    int numf;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //connexion base de donée
        try { 
            con = DriverManager.getConnection(url_db,login,mdp);      
            label.setText("Vous êtes connecté");
            label.setStyle("-fx-text-fill: green;");
        } catch (SQLException ex) {
            label.setText("Erreur de connexion");
            label.setStyle("-fx-text-fill: red;");
        }
        
        //recup N°fournisseur  table fournis colonne nomfou
        try {
            res = con.createStatement();
            result = res.executeQuery("SELECT nomfou,numfou FROM fournis");
        } catch (SQLException ex) {
            // échec
        }
        
        //construction du comboBox
        try {
            while(result.next()){               
                choix.getItems().addAll(result.getString("nomfou"));                    
            }
        } catch (SQLException ex) {
            //échec
        }
    }    

    private void select(ActionEvent event) {
        
        
        
        
     /*
        try {
            fourn = con.prepareStatement("Selectt numfou FROM fournis WHERE nomfou = discobol");
            fourn.setString(1, nomf);
            fournisseur = fourn.executeQuery();
            
            while(fournisseur.next()){
                 numf = fournisseur.getInt("numfou");
            }
                       
        } catch (SQLException ex) {
            //échec
        }
         
      */  
        
        /*
        try {
            
            numf = 9150;
            cmd = con.prepareStatement("SELECT numcom,datcom, obscom FROM entcom WHERE numfou = ?");
            cmd.setInt(1,numf);
            commande = cmd.executeQuery();
            
            while(commande.next()){
                int numc = commande.getInt("numcom");
                String datc = commande.getString("datcom");
                String obsc = commande.getString("obscom");
                
                affiche.setText(numc + " " + datc + " " + obsc);  
                
            }          
        } catch (SQLException ex) {
            //échec
        }
        
         */     
    }   

    
}
