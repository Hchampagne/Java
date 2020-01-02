/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crud_proj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.scene.control.Alert;

/**
 *
 * @author 80010-92-01
 */

public class Connect {
    
    // param connexion à la base
    private static final  String URL = "jdbc:mysql://localhost:3307/hotel?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
    private static final  String LOGIN = "root";
    private static final  String MDP = "";
    private static Connection con;
    
    public static Connection getConnection(){       
        try {
            ///connexion base
            con = DriverManager.getConnection(URL, LOGIN , MDP);
        } catch (SQLException ex) {
            //pop-up si erreur lors de la connexion
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Erreur connection à la base");
            alert.setContentText(ex.getMessage());
            alert.show();          
        }       
        // retourne la connexion
        return con;
    }    
}
