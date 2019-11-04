/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package participation;

import java.util.Scanner;

/**
 *
 * @author 80010-92-01
 */
public class Participation {

    
    public static void main(String[] args) {
       
        float salaire;
        int nbEnfant;
        String situation;
        int participation;
          
        
        Scanner lectureClavier = new Scanner(System.in);
        
        System.out.println("Entrez la situation (c / m) : ");
        situation = lectureClavier.nextLine();
               
        System.out.println("Entrez le nombre d'enfant : ");
        nbEnfant = lectureClavier.nextInt();
        
        System.out.println("Entrez le salaire : ");
        salaire = lectureClavier.nextFloat();
        
        if ("m".equals(situation)){participation = 25 ;
        }else{participation = 20 ;}
        if (nbEnfant >0){ participation = participation + nbEnfant*10 ;}
        if (participation > 50){participation = 50;}
        if (salaire < 1200f){participation += 10;}
        
        System.out.println("Participation : " + participation + " %");
      
    }
    
}