/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxapp1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * v1.00  14/11/2019
 * @author 80010-92-01
 */
public class FXapp1 extends Application{
  
    public static void main(String[] args) 
    {
        Application.launch();
    }
    
    @Override	
    public void start(Stage stage) throws Exception {
	
        Parent root = FXMLLoader.load(getClass().getResource("views/form.fxml"));	
        Scene scene = new Scene(root);	
        stage.setScene(scene);	
        stage.show();
	
    }
}
