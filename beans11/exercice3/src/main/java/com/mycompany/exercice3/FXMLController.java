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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author Doudou
 */
@SuppressWarnings("empty-statement")
public class FXMLController implements Initializable {
    
    //chmps desaisie
    @FXML
    private TextField t_nom;
    @FXML
    private TextField t_rue;
    @FXML
    private TextField t_cp;
    @FXML
    private TextField t_contact;
    @FXML
    private TextField t_ville;
    //boutons
    @FXML
    private Button ajout;
    @FXML
    private Button annuler;
    // message
    @FXML
    private Label message;
    @FXML
    private Label alertNom;
    @FXML
    private Label alertRue;
    @FXML
    private Label alertCp;
    @FXML
    private Label alertVille;
    @FXML
    private Label alertContact;
    
    //def requetes
    Connection con;
    Statement id;
    ResultSet res;
    PreparedStatement aj;
    
    //variables connexion
    String url_db ="jdbc:mysql://localhost:3306/papyrus?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
    String login = "root";
    String mdp = "";
    
    //variables
    String nom ;
    String rue ;
    String cp ;
    String ville ;        
    String contact ;
    int idMax ;
    
 
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
        
        // recup l'id max de la table
         try {
            id = con.createStatement();
            res = id.executeQuery("SELECT MAX(numfou) as numfou FROM fournis");
            while(res.next()){
                idMax = res.getInt("numfou");
                System.out.println("id =" + idMax);
            }
        } catch (SQLException ex) {
            //échec
        } 
         
        // desactive le bouton ajout 
        
        ajout.setDisable(true);
    }    

    // ajout fournisseur
    @FXML
    private void ajout(ActionEvent event) {
               
        idMax += 1; //  increment id de la table
          
        try {
            // requete preparée pour ajout
            aj = con.prepareStatement("INSERT fournis(numfou, nomfou, ruefou, posfou, vilfou,confou) value(?,?,?,?,?,?)" );
            //liaison pos/données 
            aj.setInt(1,idMax);
            aj.setString(2,nom);
            aj.setString(3,rue);
            aj.setString(4,cp);
            aj.setString(5,ville);
            aj.setString(6,contact); 
            // execute la requete
            aj.execute();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    
    //efface le formulaire
    @FXML
    private void annuler(ActionEvent event) {
        t_nom.clear();alertNom.setText("");t_nom.setStyle("-fx-border-color: black;");
        t_rue.clear();alertRue.setText("");t_rue.setStyle("-fx-border-color: black;"); 
        t_cp.clear();alertCp.setText("");t_cp.setStyle("-fx-border-color: black;"); 
        t_ville.clear();alertVille.setText("");t_ville.setStyle("-fx-border-color: black;");
        t_contact.clear();alertContact.setText("");t_contact.setStyle("-fx-border-color: black;");
    }
    
    
    @FXML
    private void nom_change(KeyEvent event) {
           
        String pattern = "^[A-Za-z0-9 éèçêë]+$";
        Pattern test = Pattern.compile(pattern);
        Matcher resu = test.matcher(t_nom.getText());
        
        if(!t_nom.getText().isEmpty()){
            if(resu.find()){
                t_nom.setStyle("-fx-border-color: green;");    
                alertNom.setText("");
                nom = t_nom.getText();
            }else {
                t_nom.setStyle("-fx-border-color: red;");
                alertNom.setText("Saisie incorrecte");
                alertNom.setStyle("-fx-text-fill: red;");
            }
        }
        else{
            t_nom.setStyle("-fx-border-color: red;");
            alertNom.setText("champs vide");
            alertNom.setStyle("-fx-text-fill: red;");
        }
    }

    @FXML
    private void rue_change(KeyEvent event) {
           
        String pattern = "^[A-Za-z0-9 éèçêë]+$";
        Pattern test = Pattern.compile(pattern);
        Matcher resu = test.matcher(t_rue.getText());
        
        if(!t_rue.getText().isEmpty()){
            if(resu.find()){
                t_rue.setStyle("-fx-border-color: green;");    
                alertRue.setText("");
                rue = t_rue.getText();
            }else {
                t_rue.setStyle("-fx-border-color: red;");
                alertRue.setText("Saisie incorrecte");
                alertRue.setStyle("-fx-text-fill: red;");
            }
        }
        else{
            t_rue.setStyle("-fx-border-color: red;");
            alertRue.setText("champs vide");
            alertRue.setStyle("-fx-text-fill: red;");
        }      
    }

    @FXML
    private void cp_change(KeyEvent event) {
        
        String pattern = "^[0-9]+$";
        Pattern test = Pattern.compile(pattern);
        Matcher resu = test.matcher(t_cp.getText());
        
        if(!t_cp.getText().isEmpty()){
            if(resu.find()){
                t_cp.setStyle("-fx-border-color: green;");    
                alertCp.setText("");
                cp = t_cp.getText();
            }else {
                t_cp.setStyle("-fx-border-color: red;");
                alertCp.setText("Saisie incorrecte");
                alertCp.setStyle("-fx-text-fill: red;");
            }
        }
        else{
            t_cp.setStyle("-fx-border-color: red;");
            alertCp.setText("champs vide");
            alertCp.setStyle("-fx-text-fill: red;");
        }
    }

    @FXML
    private void ville_change(KeyEvent event) {
        
        String pattern = "^[A-Za-z éèçêë]+$";
        Pattern test = Pattern.compile(pattern);
        Matcher resu = test.matcher(t_ville.getText());
        
        if(!t_ville.getText().isEmpty()){
            if(resu.find()){
                t_ville.setStyle("-fx-border-color: green;");    
                alertVille.setText("");
                ville = t_ville.getText();
            }else {
                t_ville.setStyle("-fx-border-color: red;");
                alertVille.setText("Saisie incorrecte");
                alertVille.setStyle("-fx-text-fill: red;");
            }
        }
        else{
            t_ville.setStyle("-fx-border-color: red;");
            alertVille.setText("champs vide");
            alertVille.setStyle("-fx-text-fill: red;");
        }
    }

    @FXML
    private void contact_change(KeyEvent event) {
        
        String pattern = "^[A-Za-z éèçêë]+$";
        Pattern test = Pattern.compile(pattern);
        Matcher resu = test.matcher(t_contact.getText());
        
        if(!t_contact.getText().isEmpty()){
            if(resu.find()){
                t_contact.setStyle("-fx-border-color: green;");    
                alertContact.setText("");
                contact = t_contact.getText();
            }else {
                t_contact.setStyle("-fx-border-color: red;");
                alertContact.setText("Saisie incorrecte");
                alertContact.setStyle("-fx-text-fill: red;");
            }
        }
        else{
            t_contact.setStyle("-fx-border-color: red;");
            alertContact.setText("champs vide");
            alertContact.setStyle("-fx-text-fill: red;");
        }
        
    } 
}  
