/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 *
 * @author Doudou
 */
public class Test extends Application {
		
    public Test() 
    {	
        System.out.println("constructeur ...");	
    }
	
    @Override
	
    public void start(Stage primaryStage) throws Exception 
    {	
        System.out.println("start ... ");
	Label label = new Label("No country ...");	
        label.relocate(70, 20);	
        label.setStyle("-fx-font-size: 30px;");	
        Pane root = new Pane();	
        root.getChildren().add(label);	
        Scene scene = new Scene( root , 300 , 100 , Color.GREY);	
        primaryStage.setTitle( "Un titre") ;	
        primaryStage.setScene(scene) ;	
        primaryStage.show() ;
        
        label.setOnMouseMoved(evt -> {System.out.println("ca bouge !");});
    }
		
    public static void main(String[] args) 
    {	
        System.out.println("main ...");
        Application.launch(args);	
    }
	
    @Override
    
    public void init() throws Exception 
    {
        System.out.println("init ...");	
    }	
}

    
    

