/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testFX2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author 80010-92-01
 */
public class TestFX2 extends Application 
{
	
    @Override
    
    public void start(Stage primaryStage) throws Exception
    {	
        System.out.println("start ... ");	
        Label label = new Label("");	
        label.setStyle("-fx-font-size: 30px;");	
        Button b = new Button("Clique moi !");	
        b.setOnAction(evt -> {	
            label.setText("Cool ...");	
        });	
        VBox root = new VBox();	
        root.getChildren().add(label);	
        root.getChildren().add(b);	
        Scene scene = new Scene( root , 300 , 100, Color.WHITE);	
        primaryStage.setTitle( "Un titre") ;	
        primaryStage.setScene(scene) ;	
        primaryStage.show() ;	
    }
		
    public static void main(String[] args)
    {	
        Application.launch(args);	
    }	
}
	


    
    

