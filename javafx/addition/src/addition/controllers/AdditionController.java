/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addition.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 * v1.00  14/11/2019
 * @author 80010-92-01
 */
public class AdditionController implements Initializable {

    @FXML
    private TextArea textaera;
    @FXML
    private Button btn1;
    @FXML
    private Button gtn0;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button bn6;
    @FXML
    private Button btn7;
    @FXML
    private Button btn8;
    @FXML
    private Button btn9;
    @FXML
    private Button vider;
    @FXML
    private Button calculer;
    
    int tmp;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btn1_click(ActionEvent event) 
    {
        textaera.appendText("+1");
        tmp += 1;
    }

    @FXML
    private void btn0_cliick(ActionEvent event) 
    {
        textaera.appendText("+0");
        tmp += 0;
    }

    @FXML
    private void btn2_cilck(ActionEvent event) 
    {
        textaera.appendText("+2");
        tmp += 2;
    }

    @FXML
    private void btn3_click(ActionEvent event) 
    {
        textaera.appendText("+3");
        tmp += 3;
    }

    @FXML
    private void btn4_click(ActionEvent event) 
    {
        textaera.appendText("+4");
        tmp += 4;
    }

    @FXML
    private void btn5_click(ActionEvent event) 
    {
        textaera.appendText("+5");
        tmp += 5;
    }

    @FXML
    private void btn6_click(ActionEvent event) 
    {
        textaera.appendText("+6");
        tmp += 6;
    }

    @FXML
    private void btn7_click(ActionEvent event) 
    {
        textaera.appendText("+7");
        tmp += 7;
    }

    @FXML
    private void btn8_click(ActionEvent event) 
    {
        textaera.appendText("+8");
        tmp += 8;
    }

    @FXML
    private void btn9_click(ActionEvent event) 
    {
        textaera.appendText("+9");
        tmp += 9;
    }

    @FXML
    private void vider_click(ActionEvent event) 
    {
        textaera.clear();
        tmp = 0;
    }

    @FXML
    private void calculer_click(ActionEvent event) 
    {             
        textaera.appendText("="); 
        String result = Integer.toString(tmp);
        textaera.appendText(result);
    }
    
}
