/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.test1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * v1.00  18/11/2019
 * @author 80010-92-01
 */
public class TestFX extends Application
{
   
    public TestFX()
        {
        System.out.println("constructeur");
        }

    @Override
    public void start(Stage primaryStage) throws Exception 
        { 
        System.out.println("start ... ");	
        Label label = new Label("cool...");	
        label.setStyle("-fx-font-size: 30px;");	
        
        Button b = new Button("Clique moi !");	
        b.setOnAction(evt -> {label.setText("Pas cool ...");});	
        
        label.setOnMouseMoved(evt ->{label.setText("Cool");});
        
        VBox root = new VBox();
        root.getChildren().add(label);	
        root.getChildren().add(b);	
        Scene scene = new Scene( root , 300 , 100 , Color.WHITE);	
        primaryStage.setTitle( "Un titre") ;	
        primaryStage.setScene(scene) ;	
        primaryStage.show() ;
        }
    
    public static void main(String[] args)
        {
        System.out.println("main");
        Application.launch(args);
        }

    @Override
    public void init() throws Exception 
        {
        System.out.println("init");
        }
    
}
    
    
    
