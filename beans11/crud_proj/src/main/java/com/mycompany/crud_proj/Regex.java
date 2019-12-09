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
    
    public String set;
    
    private static String regNom ;
    
    public Regex(){
        //default
    }
    
    public Regex(String set){
        this.set = set;
    }
    
    public static String regset(String set){
        
       if ("regNom".equals(set)){ regNom = "^[A-Z][A-Za-z0-9 éèçêë]+$"; }
        
        
        
        
        
        return regNom;
    }
    
    

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }
    
    

    
    
    
    
                
}
