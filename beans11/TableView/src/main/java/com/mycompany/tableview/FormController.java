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
    private TableView<?> Tableview;
    @FXML
    private TableColumn<?, ?> col1;
    @FXML
    private TableColumn<?, ?> col2;
    @FXML
    private TableColumn<?, ?> col3;
  

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // instanciation de l'attribut
        ObservableList<Client> model = FXCollections.observableArrayList();
        
        // Quelques clients pour notre test	
        model.add(new Client("Josh", "Homme", "Joshua Tree"));	
        model.add(new Client("Dave", "Grohl", "Warren"));	
        model.add(new Client("Krist", "Novoselic", "Compton"));	
        model.add(new Client("Robert", "Trujillo", "Santa Monica"));
        
        
        //Tableview.setItems(model);
        
        col1.setCellValueFactory(new PropertyValueFactory<Client, String>("nom"));	
        col2.setCellValueFactory(new PropertyValueFactory<Client, String>("prenom"));	
        col3.setCellValueFactory(new PropertyValueFactory<Client, String>("ville"));
        
        
        
    }      
}
