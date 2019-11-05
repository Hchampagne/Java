/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nbmagique;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author 80010-92-01
 */
public class NbMagique {

    
    public static void main(String[] args) {
        
         String choix = "exit";
        
        do{
            int x;
            
            Random rand = new Random();
            int n =rand.nextInt(100);
            System.out.println(n);
                      
            Scanner lectureClavier = new Scanner(System.in);     
            System.out.println("entrez un nombre !");
            x =lectureClavier.nextInt();
            
            while ( x != n){
                                               
            if (x < n){
                System.out.println("plus grand !");
            }else{
                System.out.println("plus petit !");
            }
                      
            System.out.println("entrez un nombre !");
            x =lectureClavier.nextInt();  
            
            }   
            System.out.println("----------------------");    
            System.out.println("Trop fort !!!");
            
            System.out.println("----------------------");
            System.out.println("Testez un autre nombre (exit pour sortir) ? ");
            lectureClavier.nextLine();
            choix = lectureClavier.nextLine();
                 
        }while(!"exit".equals(choix)); 
    }
    
}
