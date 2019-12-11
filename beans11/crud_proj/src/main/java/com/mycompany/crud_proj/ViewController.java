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
import javafx.scene.input.InputMethodEvent;
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
    private Button effacer;
    @FXML
    private Label er_nom;
    @FXML
    private Label er_prenom;
    @FXML
    private Label er_ville;

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
    => id de l'enregistrement de la table.
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
        
        //initialise les valeurs test à true valeur de la base considéré comme ok
        n1 = n2 = n3 = true;
        
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
        role = "annul";
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
                    //les champs sont vide / regex non ok=> popup  message erreur
                     Alert alert = new Alert(AlertType.ERROR);
                     alert.setHeaderText("Ajout à la base");
                     alert.setContentText("Saisie incorrecte ! ");
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
                    // les champs ne sont pas vide et regex ok
                    // instancie classe dao et update base de donnée   
                    ClientDAO update = new ClientDAO(); 
                    update.Update(up);
                    //actualise la liste
                    actual();
                }else{
                    //les champs sont vide/regex non ok => popup  message erreur
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setHeaderText("Modification de la base");
                    alert.setContentText("Modification impossible : Saisie incorrecte ! ");
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
    
    public void actual(){ //rafraichit la liste
        
        //reset false les tests 
        n1 = n2 = n3 = false;
        //instancie classe ClientDAO
        ClientDAO liste = new ClientDAO();        
        // recup le return dans model
        List<Client> model = liste.List();       
        // cast la "arraylist" en observablelist pour tableview 
        ObservableList<Client> mod = FXCollections.observableArrayList(model);
        //rempli le tableview     
        tableview.setItems(mod); 
    }
    
    public void textview(){ // 
        
        if (!"annul".equals(role)){ //si appuie bouton annuler =>else
        
        //rend visible les textview
        cache.setVisible(false);
        
        //intancie class dao pour recup row fct id  
        ClientDAO find = new ClientDAO();
        Client row = find.Find(id);
        
        // garni les textview 
       
        t_nom.setText(row.nom);
        t_prenom.setText(row.prenom);
        t_ville.setText(row.ville);
        
        // disable les champs textview pour role = delete
        if("del".equals(role)){t_nom.setDisable(true);}else{t_nom.setDisable(false);}
        if("del".equals(role)){t_prenom.setDisable(true);}else{t_prenom.setDisable(false);}
        if("del".equals(role)){t_ville.setDisable(true);}else{t_ville.setDisable(false);}
        
        //pour role add clear les textview
        if("add".equals(role)){t_nom.clear();}
        if("add".equals(role)){t_prenom.clear();}
        if("add".equals(role)){t_ville.clear();}
        
        }else{ //bouton annuler reset toutes les champs et test
            
            //reset false les tests 
             n1 = n2 = n3 = false;
            
            // active le cache menu droite
            cache.setVisible(true);
            
            //clear textview
            t_nom.clear();
            er_nom.setText("");
            t_nom.setStyle("-fx-border-color: grey;");
            t_prenom.clear();
            er_prenom.setText("");
            t_prenom.setStyle("-fx-border-color: grey;");
            t_ville.clear();
            er_ville.setText("");
            t_ville.setStyle("-fx-border-color: grey;");
        }       
    }

    @FXML
    private void nom_test(KeyEvent event) {  // champs nom si  action
        
        //obtient de la classe regex la regex du champs
        String regNom = Regex.regset("regNom");           
        
        // de la classe test obtient resultat regex et champs vide     
        n1 =  test.testreg(regNom , t_nom.getText());
        
        //gere  l'affichage fct classe test
        if(n1){
            t_nom.setStyle("-fx-border-color: green;");
            er_nom.setText("");
        }else{
            t_nom.setStyle("-fx-border-color: red;");
            er_nom.setText("Erreur de Saisie !");
            er_nom.setStyle("-fx-text-fill: red;");
        }     
    }

    @FXML
    private void prenom_test(KeyEvent event) {  //test champ prenom si action
           
       //obtient de la classe regex la regex du champs
       String regPrenom = Regex.regset("regNom");       
       // de la classe test obtient resultat regex et champs vide         
       n2 =  test.testreg(regPrenom, t_prenom.getText());
       //gere  l'affichage fct classe test
       if(n2){
            t_prenom.setStyle("-fx-border-color: green;");
            er_prenom.setText("");
       }else{
            t_prenom.setStyle("-fx-border-color: red;");
            er_prenom.setText("Erreur de Saisie !");
            er_prenom.setStyle("-fx-text-fill: red;");
       }
    }

    @FXML
    private void ville_test(KeyEvent event) {  //test champs ville si action
      
        //obtient de la classe regex la regex du champs
        String regVille = Regex.regset("regNom");       
        // de la classe test obtient resultat regex et champs vide     
        n3 =  test.testreg(regVille, t_ville.getText());
        //gere  l'affichage fct classe test
        if(n3){
            t_ville.setStyle("-fx-border-color: green;");
            er_ville.setText("");
        }else{
            t_ville.setStyle("-fx-border-color: red;"); 
            er_ville.setText("Erreur de Saisie !");
            er_ville.setStyle("-fx-text-fill: red;");
        }        
    }
    
    
    
   
    //EFFACER
    
    @FXML
    private void click_effacer(ActionEvent event) {       
        
        if(null == champs){champs = "";}
        else {
        // efface saisie en cours
        switch (champs) {
            case "t_nom":
                n1 = false;
                t_nom.setText("");
                t_nom.setStyle("-fx-border-color: grey;");
                er_nom.setText("");
                break;
            case "t_prenom":
                n2 = false;
                t_prenom.setText("");
                t_prenom.setStyle("-fx-border-color: grey;");
                er_prenom.setText("");
                break;
            case "t_ville":
                n3 = false;
                t_ville.setText("");
                t_ville.setStyle("-fx-border-color: grey;");
                er_ville.setText("");
                break;
            default:
                champs = "";
                break;
        }        
        }
    }

    @FXML
    private void efface(MouseEvent event) {
        //recup fxid du textfield cliqué
        TextField TV =(TextField)event.getSource();
        champs = TV.getId();      
    }

    
    

    
        
//fin        
} 
    


    
    

