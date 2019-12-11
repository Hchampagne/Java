/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crud_proj;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author 80010-92-01
 */

public class test {
    
    public  String reg;
    public  String champs;
    
    public test (){
        //constructeur default   
    }
    
    public test(String r, String c){
        //constructeur
        this.reg = r ;
        this.champs = c ;
    }
    
    public static boolean testreg(String reg, String champs){
                             
        // test regex
        Pattern test = Pattern.compile(reg);
        Matcher resu = test.matcher(champs);
        
        // test entrez valide champs vide et regex
        boolean res = resu.find() && (!"".equals(champs));
        // retourne booléen true si ok     
        return res;           
    }
    
    //getters et setters
    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public String getChamps() {
        return champs;
    }

    public void setChamps(String champs) {
        this.champs = champs;
    }

    
     
    
}
