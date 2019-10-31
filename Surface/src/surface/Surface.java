/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package surface;

import java.util.Scanner;

/**
 *
 * @author 80010-92-01
 */
public class Surface {
    
        //initialise constante PI
        final static double PI = 3.1416;

       public static void main(String[] args) {
           
            // variables           
            double rayon ;
            double surface;
            double perimetre;
            
            // entre le rayon
            Scanner lectureClavier = new Scanner(System.in); 
            System.out.println("Entrez le rayon :");
            rayon = lectureClavier.nextInt();
            
            //calcul perimetre
            perimetre = 2 * PI * rayon;
            
            //calcul la surface
            surface =  PI * rayon * rayon;
            
            //sortie message et resultat
            System.out.print("Le perimetre vaut : ");
            System.out.println(perimetre);
            System.out.print("La surface vaut : ");
            System.out.println(surface);      
    }   
}
