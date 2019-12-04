/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crud_proj;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author 80010-92-01
 */
public class ViewController implements Initializable {

    @FXML
    private TableColumn<Client, String> c_id;
    @FXML
    private TableColumn<Client, String> c_nom;
    @FXML
    private TableColumn<Client, String> c_prenom;
    @FXML
    private TableColumn<Client, String> c_ville;
    @FXML
    private TableView<Client> tableview;
    
    int index ;
    int id;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //instancie classe ClientDAO
        ClientDAO liste = new ClientDAO();
        
        // recup return dans model
        List<Client> model = liste.List();
        
        // cast la "arraylist" en observablelist pour tableview 
        ObservableList<Client> mod = FXCollections.observableArrayList(model);
        
        //lie les colonne avec nom variable pour extraction table view
        c_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        c_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));	
        c_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));	
        c_ville.setCellValueFactory(new PropertyValueFactory<>("ville"));
        
        
        // empeche edition table
        tableview.setEditable(false);
        
        //rempli le tableau tableview     
        tableview.setItems(mod);       
    }      

    @FXML
    private void tab_click(MouseEvent event) {       
        index = tableview.getSelectionModel().getSelectedIndex();
       
        System.out.println(index); 
    /*    
    Sur click souris selection dans tableau recup index tableau
    => id de l'enregistrement.
    */    
    }
}
