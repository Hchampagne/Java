/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crud;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 80010-92-01
 */
public class ClientDAO {
    
    public ClientDAO(){
    }
 
    //LISTE
    public List<Client> List(){               
        List<Client> resultat = new ArrayList<>();      
        try {
            String url_db ="jdbc:mysql://localhost:3306/hotel?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
            try (Connection con = DriverManager.getConnection(url_db, "root", "")) {
                ResultSet result;
                try (Statement stm = con.createStatement()) {
                    result = stm.executeQuery("SELECT * FROM client");
                    while (result.next()) {
                        Client c = new Client();
                        c.setId(result.getInt("cli_id"));
                        c.setNom(result.getString("cli_nom"));
                        c.setPrenom(result.getString("cli_prenom"));
                        c.setVille(result.getString("cli_ville"));
                        resultat.add(c);
                    }
                }
                result.close();
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("Error while reading 'client'");
            System.out.println(e.getMessage());
        }        
        return resultat;
    }
    
    
    //Ajout
    public void Insert(Client cli){
        String url_db ="jdbc:mysql://localhost:3306/hotel?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
        Connection con;
        try {
            con = DriverManager.getConnection(url_db, "root", "");
            try (PreparedStatement stm = con.prepareStatement("INSERT INTO client (cli_nom, cli_prenom, cli_ville) VALUES (?,?,?)")) {
                stm.setString(1, cli.getNom());
                stm.setString(2,cli.getPrenom());
                stm.setString(3,cli.getVille());
                
                stm.execute();
                con.close();
                stm.close();
            }
            
        } catch (SQLException e) {
            System.out.println("Error while inserting entity 'client'");
            System.out.println(e.getMessage());
        }
    }    
        
    //Suppression
    public void Delete(Client cli){
         String url_db ="jdbc:mysql://localhost:3306/hotel?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
        try {
            Connection con = DriverManager.getConnection(url_db, "root", "");
            PreparedStatement del = con.prepareStatement("DELETE FROM client WHERE cli_id = ?");
        
            del.setInt(1,cli.getId());
            del.execute();
            con.close();
            del.close();
            
        } catch (SQLException e) {
            System.out.println("Error while deleting entity 'client'");
            System.out.println(e.getMessage());
        }
    }
    
    //Modification
    public void Update(Client cli){
        String url_db ="jdbc:mysql://localhost:3306/hotel?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
        Connection con;
        try {
            con = DriverManager.getConnection(url_db, "root", "");
            PreparedStatement mod = con.prepareStatement("UPDATE client SET cli_nom = ?, cli_prenom = ?, cli_ville = ?  WHERE cli_id = ?");
                      
            mod.setString(1, cli.getNom());
            mod.setString(2, cli.getPrenom());
            mod.setString(3, cli.getVille());
            mod.setInt(4, cli.getId());
            
            mod.execute();
            mod.close();
            con.close();
            
        } catch (SQLException e) {
            System.out.println("Error while updating entity 'client'");
            System.out.println(e.getMessage());
        }
     
    }
    
    //Détail
    public Client Find(int id){
        
        ///System.out.println("id pour détail : " + id);
         
        String url_db ="jdbc:mysql://localhost:3306/hotel?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
        Connection con;
        ResultSet select;
        Client row = new Client();    
        try {
            con = DriverManager.getConnection(url_db, "root", "");
            PreparedStatement sel = con.prepareStatement("SELECT cli_id, cli_nom, cli_prenom, cli_ville FROM client WHERE cli_id = ?"); 
                sel.setInt(1, id);
                select = sel.executeQuery(); 
                
                while(select.next()){                    
                    row.setId(select.getInt("cli_id"));
                    row.setNom(select.getString("cli_nom"));
                    row.setPrenom(select.getString("cli_prenom"));
                    row.setVille(select.getString("cli_ville"));
                                       
                    //System.out.println("nom : " + (select.getString("cli_nom")));
                    //System.out.println("nom : " + (select.getString("cli_prenom")));
                    //System.out.println("nom : " + (select.getString("cli_ville")));                               
                }
            
            con.close(); 
            
        } catch (SQLException e) {
            System.out.println("Error while finding entity 'client'");
            System.out.println(e.getMessage());
        }
      return row; 
    }
    
    
    
    
    
   public static void main(String[] args) {
       /* 
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

        */
       
        //detail  
        int fi = 3;
        ClientDAO find = new ClientDAO();
        find.Find(fi);
        
        
      
      
        }
      
        }           
    

