/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nbvoyelle;

import java.util.Scanner;

/**
 *
 * @author 80010-92-01
 */
public class NbVoyelle {

    public static void main(String[] args) {
      
        String mot;
        int nbLettre;
        int nbVoyelle =0;
        String car;
        int i;
        String test = "aeuioéèàyêëù";
                                  
        Scanner lectureClavier = new Scanner(System.in);        
        System.out.println("Entrez N : ");
        mot = lectureClavier.nextLine(); 
         
        nbLettre = mot.length();
        
        System.out.print("Nombre de lettre(s) : ");
        System.out.println(nbLettre);
        
        for(i=0;i<nbLettre;i++){
        car = mot.substring(i,i+1);
        if(test.contains(car)){nbVoyelle = nbVoyelle + 1;}       
        }
        System.out.println("");
        System.out.println("Nombre de voyelle(s) : "+nbVoyelle);
    }
    
}
