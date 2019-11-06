/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nblettre;

import java.util.Scanner;

/**
 * v1.00 06/10/2019
 * @author 80010-92-01
 */
public class Nblettre {

    
    public static void main(String[] args) {
        
        String phrase ;
        String lettre ;
        
        Scanner lectureClavier = new Scanner(System.in);
        
        System.out.print("Saisir la phrase : ");
        phrase = lectureClavier.nextLine();
        
        System.out.print("Saisir la lettre : ");
        lettre = lectureClavier.nextLine();
        
        nbLettre(phrase,lettre);
        
    }
    
    public static void nbLettre(String phrase,String lettre){
        int nb = 0;
        
        for(int i=0 ; i < phrase.length() ; i++){
            if (lettre.charAt(0) == phrase.charAt(i)){
                nb++;
            } 
                
        }             
        System.out.println("Nombre de " + lettre + " = " + nb );
    }
}
