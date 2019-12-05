/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crud_proj;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author 80010-92-01
 */
public class ClientDAO {

    public ClientDAO() {
    }

    //LISTE
    public List<Client> List() {
        List<Client> resultat = new ArrayList<>();       
        String url_db = "jdbc:mysql://localhost:3306/hotel?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
        Connection con ;
        ResultSet result;
        Statement stm;
            try{ 
                con = DriverManager.getConnection(url_db, "root", "");              
                stm = con.createStatement();
                result = stm.executeQuery("SELECT * FROM client");
                
                while (result.next()) {
                    Client c = new Client();
                    c.setId(result.getInt("cli_id"));
                    c.setNom(result.getString("cli_nom"));
                    c.setPrenom(result.getString("cli_prenom"));
                    c.setVille(result.getString("cli_ville"));
                    resultat.add(c);
                }               
                result.close();
                con.close();          
            } catch (SQLException e) {
                
                Alert alert = new Alert(AlertType.ERROR);
                alert.setHeaderText("AJOUT");
                alert.setContentText("Erreur acces pour la liste /n."+ e.getMessage());
                alert.show();
        }
        return resultat;
    }

    //Ajout
    public void Insert(Client cli) {
        String url_db = "jdbc:mysql://localhost:3306/hotel?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
        Connection con;
        PreparedStatement stm;
        
            try {
                con = DriverManager.getConnection(url_db, "root", "");
                stm = con.prepareStatement("INSERT INTO client (cli_nom, cli_prenom, cli_ville) VALUES (?,?,?)");
                stm.setString(1, cli.getNom());
                stm.setString(2, cli.getPrenom());
                stm.setString(3, cli.getVille());

                stm.execute();

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setHeaderText("AJOUT");
                alert.setContentText("Ajout effectué.");
                alert.show();

                con.close();
                stm.close();
            

            } catch (SQLException e) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setHeaderText("AJOUT");
                alert.setContentText("Erreur pendant l'ajout /n."+ e.getMessage());
                alert.show();
        }
    }

    //Suppression
    public void Delete(Client cli) {
        String url_db = "jdbc:mysql://localhost:3306/hotel?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
        Connection con ;
        PreparedStatement del ;
        
        try {
            con = DriverManager.getConnection(url_db, "root", "");
            del = con.prepareStatement("DELETE FROM client WHERE cli_id = ?");

            del.setInt(1, cli.getId());
            
            del.execute();
            con.close();
            del.close();

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText("SUPPRIMER");
            alert.setContentText(" Suppression effectuée.");
            alert.show();

        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("AJOUT");
            alert.setContentText("Erreur pendant la suppression /n."+ e.getMessage());
            alert.show();
        }
    }

    //Modification
    public void Update(Client cli) {
        String url_db = "jdbc:mysql://localhost:3306/hotel?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
        Connection con;
        PreparedStatement mod ;
        
        try {
            con = DriverManager.getConnection(url_db, "root", "");
            mod = con.prepareStatement("UPDATE client SET cli_nom = ?, cli_prenom = ?, cli_ville = ?  WHERE cli_id = ?");

            mod.setString(1, cli.getNom());
            mod.setString(2, cli.getPrenom());
            mod.setString(3, cli.getVille());
            mod.setInt(4, cli.getId());

            mod.execute();

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText("MODIFICATION");
            alert.setContentText("Modification effectuée.");
            alert.show();

            mod.close();
            con.close();

        } catch (SQLException e) {
            
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("MODIFICATION");
            alert.setContentText("Erreur pendant la modification /n." + e.getMessage() );
            alert.show();   
        }
    }
        

    //Détail
    public Client Find(int id) {

        ///System.out.println("id pour détail : " + id);
        String url_db = "jdbc:mysql://localhost:3306/hotel?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
        Connection con;
        ResultSet select;
        Client row = new Client();
        try {
            con = DriverManager.getConnection(url_db, "root", "");
            PreparedStatement sel = con.prepareStatement("SELECT cli_id, cli_nom, cli_prenom, cli_ville FROM client WHERE cli_id = ?");
            sel.setInt(1, id);
            select = sel.executeQuery();

            while (select.next()) {
                row.setId(select.getInt("cli_id"));
                row.setNom(select.getString("cli_nom"));
                row.setPrenom(select.getString("cli_prenom"));
                row.setVille(select.getString("cli_ville"));                            
            }

            con.close();

        } catch (SQLException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("DeTAIL");
            alert.setContentText("Erreur pendant la requete détail /n." + e.getMessage() );
            alert.show();
        }
        return row;
    }
}
