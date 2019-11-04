/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moy;

import java.util.Scanner;

/**
 *
 * @author 80010-92-01
 */
public class Moy {

    
    public static void main(String[] args) {
        
        int nB ; 
        int x=0;
        int somme = 0;
        float moyenne = 0;
                                  
        Scanner lectureClavier = new Scanner(System.in);        
        System.out.println("Entrez un nombre : ");
        nB = lectureClavier.nextInt(); 
              
        while( nB != 0 ){       
        x=x+1;
        somme = somme + nB;
        
        System.out.println("Entrez un nombre : ");
        nB = lectureClavier.nextInt();            
        }
        
        moyenne = (float)somme / (float)x;
        
        System.out.println("somme : "+somme);
        System.out.println("nb : "+x);
        System.out.println("moyenne : "+moyenne);
    }
    
}
