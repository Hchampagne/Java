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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author 80010-92-01
 */
public class ViewController implements Initializable {
    
    int index ;
    int id ;
    

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
    @FXML
    private Button suppr;
    @FXML
    private TextField t_nom;
    @FXML
    private TextField t_prenom;
    @FXML
    private TextField t_ville;
    @FXML
    private Button modif;
    @FXML
    private Pane cache;
    @FXML
    private Button annuler;

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
    /*    
    Sur click souris selection dans tableau recup index tableau
    => id de l'enregistrement.
    */    
        index = tableview.getSelectionModel().getSelectedIndex(); // recup index       
        id = (int) tableview.getColumns().get(0).getCellObservableValue(index).getValue();  //recup id col=0 dans get
        //System.out.println("index = " + index + "   id = " + id); 
    }

    @FXML
    private void click_supr(ActionEvent event) {
        
        cache.setVisible(false);
        ClientDAO find = new ClientDAO();
        Client row = find.Find(id);         
        //System.out.println(row.id + "  " + row.nom + "  " + row.prenom + "  " + row.ville);         
        t_nom.setText(row.nom);
        t_prenom.setText(row.prenom);
        t_ville.setText(row.ville);
    }

    @FXML
    private void click_modif(ActionEvent event) {
        cache.setVisible(false);
        ClientDAO find = new ClientDAO();
        Client row = find.Find(id);                  
        t_nom.setText(row.nom);
        t_prenom.setText(row.prenom);
        t_ville.setText(row.ville);
    }

    @FXML
    private void click_annuler(ActionEvent event) {
        cache.setVisible(true);
    }
    
    
}
