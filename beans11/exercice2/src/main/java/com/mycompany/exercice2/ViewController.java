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
    @FXML
    private Label label1;
    
    //deff requetes
    Statement res;
    PreparedStatement cmd;
    PreparedStatement fourn;
    Connection con;
    ResultSet result;
    ResultSet commande;
    ResultSet fournisseur;
    
    //variables connexion
    String url_db ="jdbc:mysql://localhost:3306/papyrus?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
    String login = "root";
    String mdp = "";
    
    //variables requetes
    int numf;
    String nomf;
    String line = "";
  
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //connexion base de donnée 
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
            result = res.executeQuery("SELECT nomfou FROM fournis");
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

    @FXML
    private void select(ActionEvent event) {
        
        // recup valeur du comboBox
        nomf = choix.getValue();
        System.out.println(nomf);
        
        // recupo n°forunissuer fct nom fournisseur table forunis colonne numfou                        
        try {
            fourn = con.prepareStatement("Select numfou FROM fournis WHERE nomfou = ?");
            fourn.setString(1, nomf);
            fournisseur = fourn.executeQuery();
            
            while(fournisseur.next()){
                 numf = fournisseur.getInt("numfou");
                 System.out.println(numf);
            }                      
        } catch (SQLException ex) {
            //échec
        }   
        
        try { 
            
            // recup les commandes fct n°fournisseur table entcom colonne numcom,datcom,obscom
            cmd = con.prepareStatement("SELECT numcom,datcom, obscom FROM entcom WHERE numfou = ?");
            cmd.setInt(1,numf);
            commande = cmd.executeQuery();
            
            line = nomf + "\n";
             
            while(commande.next()){
                int numc = commande.getInt("numcom");
                String datc = commande.getString("datcom");
                String obsc = commande.getString("obscom");
                
                line += (numc + "  " + datc + "  " + obsc)+"\n";  // concatenation pour affichage
                affiche.setText(line);  
                
            }          
        } catch (SQLException ex) {
            //échec
        }           
    }   
}
