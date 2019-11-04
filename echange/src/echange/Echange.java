/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echange;

import java.util.Scanner;

/**
 *
 * @author Doudou
 */
public class Echange {

    
    public static void main(String[] args) {
        
        int nX ;
        int nY ;
              
        Scanner lectureClavier = new Scanner(System.in); 
        System.out.println("Entrez nombre X");
        nX = lectureClavier.nextInt();      
        System.out.println("Entrez nombre Y");
        nY = lectureClavier.nextInt();
        
        System.out.println("++++++++++++++++++");
        System.out.println("Valeurs");
        System.out.print("X = ");
        System.out.println(nX);
        System.out.print("Y = ");
        System.out.println(nY); 
        
        nY = nX - nY ;
        nX = nX - nY ;
        nY = nY + nX ;
        
        System.out.println("++++++++++++++++++");
        System.out.println("Résultat");
        System.out.print("X = ");
        System.out.println(nX);
        System.out.print("Y = ");
        System.out.println(nY); 
        
    }
    
}
