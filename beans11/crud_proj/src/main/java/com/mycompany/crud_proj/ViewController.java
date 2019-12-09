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
    String champs ;
    
   // String regNom = "^[A-Z][A-Za-z0-9 éèçêë]+$";
    String regPrenom = "^[A-Z][A-Za-z0-9 éèçêë]+$";
    String regVille = "^[A-Z][A-Za-z0-9 éèçêë]+$";
    
    boolean n1 = false;
    boolean n2 = false;
    boolean n3 = false;

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
    @FXML
    private Button effacer;

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
                
                if(n1 && n2 && n3){
                    // les champs ne sont pas ok regex ou vide
                    // instancie classe dao et insert base de donnée
                    ClientDAO ins = new ClientDAO();
                    ins.Insert(insert);
                    //actualise la liste
                    actual();
                }else{
                    //les champs sont vide => popup  message erreur
                     Alert alert = new Alert(AlertType.ERROR);
                     alert.setHeaderText("Ajout à la base");
                     alert.setContentText("Siasie incorrecte ! ");
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
                
                if(n1 && n2 && n3){
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
                    alert.setContentText("Saisie incorrecte ! ");
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
        
        // disable les chmaps textview pour role = mod
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
    private void nom_test(KeyEvent event) {  // champs nom si action
        
        //variable pour fct efface
        champs = "nom"; 
        
        //obtient de la classe regex la regex du champs
        String regNom = Regex.regset("regNom");       
        System.out.println(regNom);
        
        // de la classe test obtient resultat regex et champs vide     
        n1 =  test.testreg(regNom, t_nom.getText());
        
        //gere  l'affichage fct classe test
        if(n1){
            t_nom.setStyle("-fx-border-color: green;");
           
        }else{
            t_nom.setStyle("-fx-border-color: red;");
           
        }     
    }

    @FXML
    private void prenom_test(KeyEvent event) {  //test champ prenom si action
        
       champs = "prenom";
        
       n2 =  test.testreg(regPrenom, t_prenom.getText());
       
       if(n2){
            t_prenom.setStyle("-fx-border-color: green;");
            
       }else{
            t_prenom.setStyle("-fx-border-color: red;");
            
       }
    }

    @FXML
    private void ville_test(KeyEvent event) {  //test champs ville si action
        
        champs = "ville";
        
        n3 =  test.testreg(regVille, t_ville.getText());
       
        if(n3){
            t_ville.setStyle("-fx-border-color: green;");
            
        }else{
            t_ville.setStyle("-fx-border-color: red;");
           
        }        
    }

    @FXML
    private void click_effacer(ActionEvent event) {       
        
        if(null == champs){champs = "";}
        else // efface saisie en cours
        switch (champs) {
            case "nom":
                t_nom.setText("");
                break;
            case "prenom":
                t_prenom.setText("");
                break;
            case "ville":
                t_ville.setText("");
                break;
            default:
                champs = "";
                break;
        }
    }
    }


   
    
    

