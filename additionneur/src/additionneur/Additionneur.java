/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package additionneur;

import java.util.Scanner;

/**
 *
 * @author 80010-92-01
 */
public class Additionneur {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        double nX ;
        double nY;
        double result;
            
        Scanner lectureClavier = new Scanner(System.in); 
        System.out.println("Entrez le premier nombre");
        nX = lectureClavier.nextInt();         
        System.out.println("Entrez le deuxième nombre");
        nY = lectureClavier.nextInt();        
        
        result = nX + nY;
        
        System.out.print("Résultat : ");
        System.out.println(  nX + " + " + nY + " = " + result );
      
    }
    
}
