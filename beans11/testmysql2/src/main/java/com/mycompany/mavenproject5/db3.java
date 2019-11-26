/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Doudou
 */
public class db3 {
    public static void main(String[] args) {
        try {
                    
            String url = "jdbc:mysql://localhost:3306/papyrus?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
	
            Connection con;
            con = DriverManager.getConnection(url, "root", "");
		
            PreparedStatement stm;
            stm= con.prepareStatement("INSERT INTO fournis (numfou, nomfou, ruefou, vilfou, posfou, confou) VALUES (?, ?, ?, ?, ?, ?)");
		
            stm.setInt(1, 11111);	
            stm.setString(2, "toto");
            stm.setString(3, "bibi");	
            stm.setString(4, "Amiens");	
            stm.setString(5, "80000");	
            stm.setString(6, "ee");	
            stm.execute();	
            stm.close();	
            con.close();	
            System.out.println("success!");
        } catch (SQLException e) {	
            System.out.println("Error!");	
            System.out.println(e.getMessage());	
        }   
    }
}
