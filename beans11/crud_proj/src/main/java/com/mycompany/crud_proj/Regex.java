/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crud_proj;

/**
 *
 * @author 80010-92-01
 */
public class Regex {
    
    private  String set;
    
    private static String regNom = "^[A-Z][A-Za-z éèçêë]+$";
    private static String regPrenom = "^[A-Z][A-Za-z éèçêë]+$";
    private static String regVille = "^[A-Z][A-Za-z éèçêë]+$";
    
    private static String result;
    
    public Regex(){
        //default
    }
    
    public Regex(String set){
        this.set = set;
    }
    
    public static String regset(String set){
       
       if ("regNom".equals(set)){result = regNom;}
       if ("regPrenom".equals(set)){result = regPrenom;}       
       if ("regVille".equals(set)){result = regVille;} 
       
       return result;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }                 
}
