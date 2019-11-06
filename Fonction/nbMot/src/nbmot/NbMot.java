/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nbmot;

import java.util.Scanner;

/**
 * v1.00 06/10/2019
 * @author 80010-92-01
 */
public class NbMot {

    public static void main(String[] args) {
               
        String phrase;
        String choix;
        
        do{
         Scanner lectureClavier = new Scanner(System.in);
         System.out.print("Saisir la phrase : ");
         phrase = lectureClavier.nextLine();
         System.out.println("Résultat =" + mot(phrase) );
        
         System.out.print("Nouvel essai (o/n): ");
         choix = lectureClavier.nextLine();
        }while(!choix.equals("n"));
    }
    
    public static int mot(String phrase){
        int nb;
        String[] words = phrase.split(" ");
        nb = words.length;        
        return nb;
    }
}
