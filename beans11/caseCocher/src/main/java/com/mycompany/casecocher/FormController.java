/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.casecocher;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;

/**
 * FXML Controller class
 *
 * @author 80010-92-01
 */
public class FormController implements Initializable {

    @FXML
    private TextField saisie;
    @FXML
    private Label label;
    @FXML
    private TitledPane choix;
    @FXML
    private CheckBox c_fond;
    @FXML
    private CheckBox c_texte;
    @FXML
    private CheckBox c_casse;
    @FXML
    private TitledPane texte;
    @FXML
    private TitledPane casse;
    @FXML
    private RadioButton t_rouge;
    @FXML
    private RadioButton f_rouge;
    @FXML
    private RadioButton f_vert;
    @FXML
    private RadioButton f_bleu;
    @FXML
    private TitledPane fond;
    @FXML
    private RadioButton t_blanc;
    @FXML
    private RadioButton t_noir;
    @FXML
    private RadioButton min;
    @FXML
    private RadioButton maj;
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     * desactive choix/fond/texte/casse
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choix.setDisable(true);
        fond.setDisable(true);
        texte.setDisable(true);
        casse.setDisable(true);
    }    
// saisie et transf ds label active choix
    @FXML
    private void saisie_change(ActionEvent event) {
        label.setText(saisie.getText());
        choix.setDisable(false);
    }
    //active fond si select fond
    @FXML
    private void c_fond_select(ActionEvent event) {
        
        if (fond.isDisabled()) {fond.setDisable(false);
        } else {
             fond.setDisable(true);
        }       
    }
    //active texte si select casse
    @FXML
    private void c_casse_select(ActionEvent event) {
        
        if (casse.isDisabled()) {casse.setDisable(false);
        } else {
             casse.setDisable(true);
        } 
        
        //casse.setDisable(false);
    }
    //active texte si select texte
    @FXML
    private void c_texte_select(ActionEvent event) {
        
        if (texte.isDisabled()) {texte.setDisable(false);
        } else {
             texte.setDisable(true);
        } 
        //texte.setDisable(false);
    }
//gestion fond
    //fond rouge
    @FXML
    private void f_rouge_select(ActionEvent event) {
        String style = label.getStyle();
        label.setStyle(style+"-fx-background-color: red;");
        f_rouge.setSelected(true);
        f_vert.setSelected(false);
        f_bleu.setSelected(false);
    }
    //fond vert
    @FXML
    private void f_vert_select(ActionEvent event) {
        String style = label.getStyle();
        label.setStyle(style+"-fx-background-color: green;");
        f_rouge.setSelected(false);
        f_vert.setSelected(true);
        f_bleu.setSelected(false);
        
    }
    //fond bleu
    @FXML
    private void f_bleu_select(ActionEvent event) {
        String style = label.getStyle();
        label.setStyle(style+"-fx-background-color: blue;");
        f_rouge.setSelected(false);
        f_vert.setSelected(false);
        f_bleu.setSelected(true);
    }
//gestion texte
    //texte rouge
    @FXML
    private void t_rouge_select(ActionEvent event) {
        String style = label.getStyle();
        label.setStyle(style+"-fx-text-fill: red;");
        t_rouge.setSelected(true);
        t_blanc.setSelected(false);
        t_noir.setSelected(false);
    }
    //texte blanc
    @FXML
    private void t_blanc_select(ActionEvent event) {
        String style = label.getStyle();
        label.setStyle(style+"-fx-text-fill: white;");
        t_rouge.setSelected(false);
        t_blanc.setSelected(true);
        t_noir.setSelected(false);
    }
    //texte noir
    @FXML
    private void t_noir_select(ActionEvent event) {
        String style = label.getStyle();
        label.setStyle(style+"-fx-text-fill: black;");
        t_rouge.setSelected(false);
        t_blanc.setSelected(false);
        t_noir.setSelected(true);
    }
// gestion maj/minus
    //minus
    @FXML
    private void min_select(ActionEvent event) {
        
        String text = label.getText();
        label.setText(text.toLowerCase());
        min.setSelected(true);
        maj.setSelected(false);
    }
    //maj
    @FXML
    private void maj_select(ActionEvent event) {
        
        String text = label.getText();
        label.setText(text.toUpperCase());
        min.setSelected(false);
        maj.setSelected(true);
    }
    
    
}
