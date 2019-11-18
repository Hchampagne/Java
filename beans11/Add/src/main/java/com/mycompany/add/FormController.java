/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.add;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author 80010-92-01
 */
public class FormController implements Initializable {
    
    int tmp ;

    @FXML
    private TextArea affiche;
    @FXML
    private Button btn0;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btn7;
    @FXML
    private Button btn8;
    @FXML
    private Button btn9;
    @FXML
    private Button calcul;
    @FXML
    private Button vider;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void btn0_click(ActionEvent event) {
        affiche.appendText("+0");
        tmp += 0;
    }

    @FXML
    private void btn1_click(ActionEvent event) {
        affiche.appendText("+1");
        tmp += 1;
    }

    @FXML
    private void btn2_click(ActionEvent event) {
        affiche.appendText("+2");
        tmp += 2;
    }

    @FXML
    private void btn3_click(ActionEvent event) {
        affiche.appendText("+3");
        tmp += 3;
    }

    @FXML
    private void btn4_click(ActionEvent event) {
        affiche.appendText("+4");
        tmp += 4;
    }

    @FXML
    private void btn5_click(ActionEvent event) {
        affiche.appendText("+5");
        tmp += 5;
    }

    @FXML
    private void btn6_click(ActionEvent event) {
        affiche.appendText("+6");
        tmp += 6;
    }

    @FXML
    private void btn7_click(ActionEvent event) {
        affiche.appendText("+7");
        tmp += 7;
    }

    @FXML
    private void btn8_click(ActionEvent event) {
        affiche.appendText("+8");
        tmp += 8;
    }

    @FXML
    private void btn9_click(ActionEvent event) {
        affiche.appendText("+9");
        tmp += 9;
    }

    @FXML
    private void calcul_click(ActionEvent event) {
        
        affiche.appendText("="); 
        String result = Integer.toString(tmp);
        affiche.appendText(result);
    }

    @FXML
    private void vider_click(ActionEvent event) {
        affiche.clear();
        tmp = 0;
    }
    
}
