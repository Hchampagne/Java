package com.mycompany.crud_proj;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Table clients");
        scene = new Scene(loadFXML("view"));
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
        
        
        
       /* 
        
       jeu test client dao
        
       //ajout
       Client insert = new Client();
       insert.nom = "Lebowski";
       insert.prenom = "Jeffrey";
       insert.ville = "Los Angeles";
      
       ClientDAO ins = new ClientDAO();
       ins.Insert(insert);
           
       //liste
        ClientDAO liste = new ClientDAO();
        
        liste.List().forEach((c) -> {
            System.out.println(c.id + "  " + c.nom + "  " + c.prenom +"  " + c.ville);
        });
        
      
        //Suppression
        Client suppr = new Client();
        suppr.id = 16;
        
        ClientDAO del = new ClientDAO();
        del.Delete(suppr);
        
        //modifier 
        Client up = new Client();
        up.id = 1;
        up.nom = "Lebowski";
        up.prenom = "Jf";
        up.ville = "new york";
        
        ClientDAO update = new ClientDAO(); 
        update.Update(up);

        
       
        //detail  
        int fi = 3;
        ClientDAO find = new ClientDAO();
        Client row = find.Find(fi);
         
        System.out.println(row.id + "  " + row.nom + "  " + row.prenom + "  " + row.ville);     
        }
      */
    }

}