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
    
    //param connexion db
    String url_db = "jdbc:mysql://localhost:3306/hotel?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
    String login ="root";
    String mdp = ""; 
       
    public ClientDAO() {
        //constructeur defaut
    }
    
    //LISTE
    public List<Client> List() {
        // instaciation arraylist
        List<Client> resultat = new ArrayList<>();       
        // connexion db
        Connection con ;
        ResultSet result;
        Statement stm;
            try{ //connexion db et statement
                con = DriverManager.getConnection(url_db,login, mdp);              
                stm = con.createStatement();
                result = stm.executeQuery("SELECT * FROM client");
                // lecture et objet Client
                while (result.next()) {
                    Client c = new Client(); 
                    c.setId(result.getInt("cli_id"));
                    c.setNom(result.getString("cli_nom"));
                    c.setPrenom(result.getString("cli_prenom"));
                    c.setVille(result.getString("cli_ville"));
                    resultat.add(c); // addition des objet client dans arraylist
                }               
                result.close();//close statement
                con.close();   //close connexion       
            } catch (SQLException e) {
                //popup alert erreur
                Alert alert = new Alert(AlertType.ERROR);
                alert.setHeaderText("AJOUT");
                alert.setContentText("Erreur acces pour la liste /n."+ e.getMessage());
                alert.show();
        }
        return resultat;//retourne le resultat
    }

    //Ajout
    public void Insert(Client cli) {
        //param connexion bd
        Connection con;
        PreparedStatement stm;
        
            try {//connexion bd requete preparée
                con = DriverManager.getConnection(url_db,login, mdp);  
                stm = con.prepareStatement("INSERT INTO client (cli_nom, cli_prenom, cli_ville) VALUES (?,?,?)");
                //liaison variable position requete
                stm.setString(1, cli.getNom());
                stm.setString(2, cli.getPrenom());
                stm.setString(3, cli.getVille());
                // execution de la requete
                stm.execute();
                //popup insert réussi
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setHeaderText("AJOUT");
                alert.setContentText("Ajout effectué.");
                alert.show();
                //fermeture statement et connexion bd
                con.close();
                stm.close();
            

            } catch (SQLException e) {
                //popup si erreur
                Alert alert = new Alert(AlertType.ERROR);
                alert.setHeaderText("AJOUT");
                alert.setContentText("Erreur pendant l'ajout /n."+ e.getMessage());
                alert.show();
        }
    }

    //Suppression
    public void Delete(Client cli) {
        // param connexion
        Connection con ;
        PreparedStatement del ;
        
        try {
            //connexion bd et requete preparée
            con = DriverManager.getConnection(url_db,login, mdp);  
            del = con.prepareStatement("DELETE FROM client WHERE cli_id = ?");
            //liaison variable position requete
            del.setInt(1, cli.getId());
            //execution requete
            del.execute();
            //fermeture statement et connexion
            con.close();
            del.close();
            //popupp suppr reussi
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText("SUPPRIMER");
            alert.setContentText(" Suppression effectuée.");
            alert.show();

        } catch (SQLException e) {
            //popup si erreur
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("AJOUT");
            alert.setContentText("Erreur pendant la suppression /n."+ e.getMessage());
            alert.show();
        }
    }

    //Modification
    public void Update(Client cli) {
        //param connexion
        Connection con;
        PreparedStatement mod ;
        
        try {
            //connexion et re requete preparée
            con = DriverManager.getConnection(url_db,login, mdp);  
            mod = con.prepareStatement("UPDATE client SET cli_nom = ?, cli_prenom = ?, cli_ville = ?  WHERE cli_id = ?");
            //liaison variable position requete
            mod.setString(1, cli.getNom());
            mod.setString(2, cli.getPrenom());
            mod.setString(3, cli.getVille());
            mod.setInt(4, cli.getId());
            // exécution requete
            mod.execute();
            //fermeture statement et connexion
            mod.close();
            con.close();
            
            // pop-up si modif réussi
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText("MODIFICATION");
            alert.setContentText("Modification effectuée.");
            alert.show();
            
        } catch (SQLException e) {
            
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("MODIFICATION");
            alert.setContentText("Erreur pendant la modification /n." + e.getMessage() );
            alert.show();   
        }
    }
        

    //Détail
    public Client Find(int id) {
        //param connexion
        Connection con;
        ResultSet select;
        
        //instanciation de la classe client
        Client row = new Client();
        
        try {
            //connexion et re requete preparé
            con = DriverManager.getConnection(url_db,login, mdp);  
            PreparedStatement sel = con.prepareStatement("SELECT cli_id, cli_nom, cli_prenom, cli_ville FROM client WHERE cli_id = ?");
            //liaison variable position requete
            sel.setInt(1, id);
            // exécution requete et recup row db
            select = sel.executeQuery();
            // lecture resultat requete et set du client instancié
            while (select.next()) {
                row.setId(select.getInt("cli_id"));
                row.setNom(select.getString("cli_nom"));
                row.setPrenom(select.getString("cli_prenom"));
                row.setVille(select.getString("cli_ville"));                            
            }
            //fermeture statement et requete
            sel.close();
            con.close();

        } catch (SQLException e) {
            //pop-up si erreur
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("DeTAIL");
            alert.setContentText("Erreur pendant la requete détail /n." + e.getMessage() );
            alert.show();
        }
        // retourne le client instancié
        return row; 
    }
}
