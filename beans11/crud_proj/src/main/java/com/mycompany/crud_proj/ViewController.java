/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crud_proj;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
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
    String role ;
    

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
    private TextField t_nom;
    @FXML
    private TextField t_prenom;
    @FXML
    private TextField t_ville;
    @FXML
    private Button modif;
    @FXML
    private Button annuler;
    @FXML
    private Button ok;
    @FXML
    private Button ajouter;
    @FXML
    private Pane cache;
    @FXML
    private Button supprimer;
    @FXML
    private Label mess_error;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             
        //instancie classe ClientDAO
        ClientDAO liste = new ClientDAO();        
        // recup le return dans model
        List<Client> model = liste.List();       
        // cast la "arraylist" en observablelist pour tableview 
        ObservableList<Client> mod = FXCollections.observableArrayList(model);
        
        //lie les colonnes avec nom variable pour insertion dans tableview
        c_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        c_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));	
        c_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));	
        c_ville.setCellValueFactory(new PropertyValueFactory<>("ville"));
        
        
        // empeche edition table
        tableview.setEditable(false);
        
        //rempli le tableview     
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
             
        if (!"add".equals(role)){// si selection addition ne garni pas les textview
        // intancie class dao pour recup row fct id   
        ClientDAO find = new ClientDAO();
        Client row = find.Find(id); 
        // garni les textview
        t_nom.setText(row.nom);   
        t_prenom.setText(row.prenom);
        t_ville.setText(row.ville);
        }     
    }

    @FXML
    private void click_supr(ActionEvent event) {
        
        // fourni le role = del appuie bouton suppression (switch/case)
        role = "del";       
        //  textview / non modifiable
        textview();               
    }

    @FXML
    private void click_modif(ActionEvent event) {
        
        //fournis le role = mod appuie bouton modification (switc/case)
        role = "mod";      
        //  textview  / modifiable
        textview();
             
    }
    
        @FXML
    private void click_ajouter(ActionEvent event) {
        
        //fournis le role = mod appuie bouton ajout (switc/case)
        role = "add";       
        // clear textview / modifiable
        textview();     
    }

    @FXML
    private void click_annuler(ActionEvent event) {
        
        //fournis le role = "" appuie bouton annuler 
        role = "";
        //vide les textview et cache menu de droite
        textview();      
    }
   
    @FXML
    private void click_ok(ActionEvent event) {
        
        switch(role){
            
            case "add" : 
                // instancie un client
                Client insert = new Client();
                insert.nom = t_nom.getText();
                insert.prenom = t_prenom.getText();
                insert.ville = t_ville.getText();
                
                if(!"".equals(t_nom.getText())  && !"".equals(t_prenom.getText()) && !"".equals(t_ville.getText())){
                    // les champs ne sont pas vide
                    // instancie classe dao et insert base de donnée
                    ClientDAO ins = new ClientDAO();
                    ins.Insert(insert);
                    //actualise la liste
                    actual();
                }else{
                    //les champs sont vide => popup  message erreur
                     Alert alert = new Alert(AlertType.ERROR);
                     alert.setHeaderText("Ajout à la base");
                     alert.setContentText("Attention champs vide(s) ! ");
                     alert.show();
                }
                
                break ;
                
            case "mod" : 
                // instancie un client
                Client up = new Client();
                up.id = id;               
                up.nom = t_nom.getText();
                up.prenom = t_prenom.getText();
                up.ville = t_ville.getText(); 
                
                if(!"".equals(t_nom.getText())  && !"".equals(t_prenom.getText()) && !"".equals(t_ville.getText())){
                    // les champs ne sont pas vide
                    // instancie classe dao et update base de donnée   
                    ClientDAO update = new ClientDAO(); 
                    update.Update(up);
                    //actualise la liste
                    actual();
                }else{
                    //les champs sont vide => popup  message erreur
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setHeaderText("Modification de la base");
                    alert.setContentText("Attention champs vide(s) ! ");
                    alert.show();
                }
                break;
            
            case "del" :
                // instancie un client juste sur id
                Client suppr = new Client();
                suppr.id = id; 
                // les champs ne sont pas vide
                // instancie classe dao et delete row dans base de donnée
                ClientDAO del = new ClientDAO();
                del.Delete(suppr); ;                
                //actualise la liste
                actual();
                break ;
                
            default :  break ;      
        }           
    }
    
    public void actual(){
           
        //instancie classe ClientDAO
        ClientDAO liste = new ClientDAO();        
        // recup le return dans model
        List<Client> model = liste.List();       
        // cast la "arraylist" en observablelist pour tableview 
        ObservableList<Client> mod = FXCollections.observableArrayList(model);
        //rempli le tableview     
        tableview.setItems(mod); 
    }
    
    public void textview(){
        
        if (!"".equals(role)){ //si appuie bouton annuler =>else
        
        //rend visible les textview
        cache.setVisible(false);
        
        //intancie class dao pour recup row fct id  
        ClientDAO find = new ClientDAO();
        Client row = find.Find(id);
        
        // garni les textview et les rend non modifiable
        t_nom.setText(row.nom);
        t_prenom.setText(row.prenom);
        t_ville.setText(row.ville);
        
        // disable les chmaps textview pour role=mod
        if("del".equals(role)){t_nom.setDisable(true);}else{t_nom.setDisable(false);}
        if("del".equals(role)){t_prenom.setDisable(true);}else{t_prenom.setDisable(false);}
        if("del".equals(role)){t_ville.setDisable(true);}else{t_ville.setDisable(false);}
        
        //pour role add clear les textview
        if("add".equals(role)){t_nom.clear();}
        if("add".equals(role)){t_prenom.clear();}
        if("add".equals(role)){t_ville.clear();}
        
        }else{
            // active le cache menu droite
            cache.setVisible(true);
            
            //clear textview
            t_nom.clear();
            t_prenom.clear();
            t_ville.clear();       
        }       
    }

    @FXML
    private void nom_test(KeyEvent event) {
               
        String pattern = "^[A-Z][A-Za-z0-9 éèçêë]+$";
        Pattern test = Pattern.compile(pattern);
        Matcher resu = test.matcher(t_nom.getText());
        
        if(!t_nom.getText().isEmpty()){
            if(resu.find()){                
                t_nom.setStyle("-fx-border-color: green;");
                ok.setDisable(false);
                //good             
            }else {               
                t_nom.setStyle("-fx-border-color: red;");
                ok.setDisable(true);
              // pas good regex
            } 
        }
        else{           
            t_nom.setStyle("-fx-border-color: red;");
            ok.setDisable(true);
           //pas good vide
        }
    }

    @FXML
    private void prenom_test(KeyEvent event) {
        
        String pattern = "^[A-Z][A-Za-z0-9 éèçêë]+$";
        Pattern test = Pattern.compile(pattern);
        Matcher resu = test.matcher(t_prenom.getText());
        
        if(!t_prenom.getText().isEmpty()){
            if(resu.find()){                
                t_prenom.setStyle("-fx-border-color: green;");
                ok.setDisable(false);
                //good             
            }else {               
                t_prenom.setStyle("-fx-border-color: red;");
                ok.setDisable(true);
              // pas good regex
            } 
        }
        else{           
            t_prenom.setStyle("-fx-border-color: red;");
            ok.setDisable(true);
           //pas good vide    
        }
    }

    @FXML
    private void ville_test(KeyEvent event) {
        
        String pattern = "^[A-Z][A-Za-z0-9 éèçêë]+$";
        Pattern test = Pattern.compile(pattern);
        Matcher resu = test.matcher(t_ville.getText());
        
        if(!t_ville.getText().isEmpty()){
            if(resu.find()){                
                t_ville.setStyle("-fx-border-color: green;");
                ok.setDisable(false);
                //good             
            }else {               
                t_ville.setStyle("-fx-border-color: red;");
                ok.setDisable(true);
              // pas good regex
            } 
        }
        else{           
            t_ville.setStyle("-fx-border-color: red;");
            ok.setDisable(true);
           //pas good vide
        }
    }
    }


   
    
    

