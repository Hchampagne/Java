/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 80010-92-01
 */
public class db1 {
    
    public static void main(String[] args) {
    try	
        {	
            String url ="jdbc:mysql://localhost:3306/papyrus?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
            String login = "root";
            String mdp = "";
            Statement res;
            Connection con;
            ResultSet result;
            
            con = DriverManager.getConnection(url,login,mdp);
            res = con.createStatement();
            result = res.executeQuery("SELECT * FROM fournis");
            
            while (result.next()) {	
                int num = result.getInt("numfou");	
                String nom = result.getString("nomfou");	
                String ville = result.getString("vilfou");	
                System.out.format("[%d] %s %s\n", num, nom, ville);	
            }	
            res.close();	
            result.close();	
            con.close();
            
            System.out.println ("ça marche ");	
        }	
    catch(SQLException e)	
        {	
            System.out.println ("la connexion a échoué");
            System.out.println(e.getMessage());
        }
    }
}
