/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concatenation;

import java.util.Scanner;

/**
 *
 * @author 80010-92-01
 */
public class Concatenation {

    public static void main(String[] args) {
        String conc="";
        String chaine="";
       
        Scanner lectureClavier = new Scanner(System.in);
        
        while(!chaine.equals("=")){
            if(!chaine.equals("=")){                
                conc = concat(conc,chaine);
                System.out.println(conc);
                System.out.print("Entrez chaine : ");
                chaine = lectureClavier.nextLine();            
            }
        }
    }
    
    public static String concat(String conc, String chaine){    
        conc += chaine;
        return conc;   
    }
    
}
