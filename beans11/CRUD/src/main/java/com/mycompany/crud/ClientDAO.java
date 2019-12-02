/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crud;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
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
                        resultat.add(c);
                    }
                }
                result.close();
            }
        } catch (SQLException e) {
            System.out.println("Error while reading 'client'");
            System.out.println(e.getMessage());
        }        
        return resultat;
    }
    
   public static void main(String[] args) {
        ClientDAO repo = new ClientDAO();
        repo.List().forEach((c) -> {
            System.out.println(c.id + "  " + c.nom + "  " + c.prenom);
        });
    }
}
