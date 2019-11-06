/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculette;

import java.util.Scanner;

/**
 *
 * @author 80010-92-01
 */
public class Calculette {

    public static void main(String[] args) {
        
         int nX;
         int nY;
     
         int result;
        
        System.out.print("Entrez le premier nombre : ");
        Scanner lectureClavier = new Scanner(System.in);
        nX = lectureClavier.nextInt();
        
        System.out.print("Entrez le deuxième nombre : ");
        nY = lectureClavier.nextInt();
        
        lectureClavier.nextLine();  // vide la ligne avant de lire la suivante
        
        System.out.print("Entrez l'opérateur : ");
        String operateur = lectureClavier.nextLine();
        
        System.out.println("opérateur : " + operateur);
        
        switch(operateur){       
            case "+" : 
                result = nX + nY;
                System.out.println("resultat addition = " + result);
                break;                  
            case "-" :
                result = nX - nY;
                System.out.println("resultat soustraction = " + result);
                break;      
            case "*" :
                result = nX * nY;
                System.out.println("resultat multiplication = " + result);
                break;           
            case "" :
                result = nX / nY;
                System.out.println("resultat division = " + result);
                break;                
            default : 
                 System.out.println("Ce n'est pas un opérateur !!!");
               
        }
    
}
}
