/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiples;

import java.util.Scanner;

/**
 *
 * @author 80010-92-01
 */
public class Multiples {

    
    public static void main(String[] args) {
       
         int N;
         int X;
         int i;
                                  
        Scanner lectureClavier = new Scanner(System.in);        
        System.out.println("Entrez N : ");
        N = lectureClavier.nextInt(); 
        System.out.println("Entrez X : ");
        X = lectureClavier.nextInt(); 
        
        for(i=1;i<=N;i++){ System.out.println(i + " * "+ X + " = " + (i*X));}
    }
    
}
