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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author 80010-92-01
 */
public class FormController implements Initializable {

    
    @FXML
    private TableColumn<?,?> prenom;
    @FXML
    private TableColumn<?,?> nom;
    @FXML
    private TableColumn<?,?> ville;  
    @FXML
    private TableView<?> clients;
    
    //ObservableList<Client> model;
  
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */ 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
         //initialisation du modèle
        final ObservableList<Client> model = FXCollections.observableArrayList(
            new Client("Josh", "Homme", "Joshua Tree"),	
            new Client("Dave", "Grohl", "Warren"),	
            new Client("Krist", "Novoselic", "Compton"),	
            new Client("Robert", "Trujillo", "Santa Monica")	
        ); 
            
        //On rend le tableau non-éditable	
        clients.setEditable(false);	
        // Jonction du tableau avec les données	
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));	
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));	
        ville.setCellValueFactory(new PropertyValueFactory<>("ville"));
		
       clients.setItems(model);
        
    }   
}
