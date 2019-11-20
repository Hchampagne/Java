/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.melange1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author 80010-92-01
 */
public class FormController implements Initializable {

    @FXML
    private Slider rouge;
    @FXML
    private Slider vert;
    @FXML
    private Slider bleu;
    @FXML
    private Label label;
    @FXML
    private Label t_rouge;
    @FXML
    private Label t_vert;
    @FXML
    private Label t_bleu;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //affiche rgb 0,0,0 =>noir
        int r = (int) rouge.getValue();
        int v = (int)vert.getValue();
        int b = (int)bleu.getValue();  
        
        label.setStyle("-fx-background-color: rgb(" + r + "," + v + "," + b +");");
    }    

    @FXML
    private void initialize(MouseEvent event) {
        // recup valeur pour le rouge
        int r = (int)rouge.getValue();
        String red = Integer.toString(r);
        t_rouge.setText(red);
        // recup valeur pour le vert
        int v = (int)vert.getValue();
        String green = Integer.toString(v);
        t_vert.setText(green);
        //recup valeur pour le bleu
        int b = (int)bleu.getValue();
        String blue = Integer.toString(b);
        t_bleu.setText(blue);
        
        //affiche backgound
        label.setStyle("-fx-background-color: rgb(" + r + "," + v + "," + b +");");
    }    
}
