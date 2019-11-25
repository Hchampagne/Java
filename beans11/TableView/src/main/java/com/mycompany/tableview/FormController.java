/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tableview;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author 80010-92-01
 */

public class FormController implements Initializable {

    
    @FXML
    private TableColumn<Client,String> prenom;
    @FXML
    private TableColumn<Client,String> nom;
    @FXML
    private TableColumn<Client,String> ville;  
    @FXML
    private TableView<Client> clients;
    
    ObservableList<Client> model;
    
    @FXML
    private Button sauver;
    @FXML
    private Button annuler;
    @FXML
    private Button supprimer;
    @FXML
    private TextField t_ville;
    @FXML
    private TextField t_prenom;
    @FXML
    private TextField t_nom;
   
  
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */ 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        model =  FXCollections.observableArrayList();
        
        //initialisation du modèle              
        model.add(new Client("Josh", "Homme", "Joshua Tree"));	
        model.add(new Client("Dave", "Grohl", "Warren"));	
        model.add(new Client("Krist", "Novoselic", "Compton"));	
        model.add(new Client("Robert", "Trujillo", "Santa Monica"));
        
        //model.setAll(
        //        new Client("Josh", "Homme", "Joshua Tree"),
        //        new Client("Dave", "Grohl", "Warren"),
        //        new Client("Krist", "Novoselic", "Compton"),
        //        new Client("Robert", "Trujillo", "Santa Monica"),
        //);
                   
        //On rend le tableau non-éditable	
        clients.setEditable(false);	
        
        // Jonction du tableau avec les données	
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));	
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));	
        ville.setCellValueFactory(new PropertyValueFactory<>("ville"));
              
       clients.setItems(model);
                     
    }

    @FXML
    private void click_sauve(ActionEvent event) {  // ajout 
        // recup valeurs des champs
        String n_prenom = t_prenom.getText();
        String n_nom = t_nom.getText();
        String n_ville = t_ville.getText();       
        // test champs vide
        if (!n_prenom.equals("") && !n_nom.equals("") && !n_ville.equals("")){
            //ajout à liste
            model.add(new Client(n_prenom, n_nom, n_ville));
            clients.setItems(model);
        }   
    }

    @FXML
    private void click_annul(ActionEvent event) { //efface les champs de saisie
        t_prenom.clear();
        t_nom.clear();
        t_ville.clear();    
    }

    @FXML
    private void click_suppr(ActionEvent event) {  //supprime une entrée /ligne      
        model.remove(getSelectedItems());
        clients.setItems(model);
        
    }
  }  

