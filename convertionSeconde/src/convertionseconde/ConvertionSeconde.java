/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertionseconde;

import java.util.Scanner;

/**
 *
 * @author 80010-92-01
 */
public class ConvertionSeconde {

   
    public static void main(String[] args) {
        
        int temps;
        int seconde;
        int minute;
        int heure;    
        
       Scanner lectureClavier = new Scanner(System.in); 
       System.out.print("Entrez le temps en seconde (s) : ");
       temps = lectureClavier.nextInt(); 
       
       seconde = temps % 60 ;
       heure = (temps - seconde) / 3600;
       minute = ((temps - seconde) - (heure * 3600)) / 60;
       
      
       System.out.println("Temps en seconde  : " + temps);
       
       System.out.println("Temps  " + heure + ":" +minute + ":" + seconde);
    }
    
}
