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
        String choix;
        int nbLettre;       
        String test = "aeuioéèàyêëù";
                                  
        Scanner lectureClavier = new Scanner(System.in);  
        
        do{
        int nbVoyelle = 0;
            
        System.out.print("Entrez le mot : ");
        mot = lectureClavier.nextLine(); 
         
        nbLettre = mot.length();       
        System.out.println("Nombre de lettre(s) : "+nbLettre);       
        
        for(int i=0;i<nbLettre;i++){
        if(test.contains(mot.substring(i,i+1))){nbVoyelle++;}       
        }        
        System.out.println("Nombre de voyelle(s) : "+nbVoyelle);
        
        System.out.print("Encore un essai (o/n) : ");
        choix = lectureClavier.nextLine();
        System.out.println(" ");
        }while(choix.equals("o") );
    }
    
}
