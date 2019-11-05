/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tab_ex1;

/**
 *
 * @author 80010-92-01
 */

import java.util.Scanner;


public class Tab_ex1 {
        
        
    
    public static void main(String[] args) {
        
        int x;
             
        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("Entrez taille du tableau : ");
        x = lectureClavier.nextInt();
        int tab[] = new int[x]; 
        
        for(int i=1 ; i<=x ; i++){        
            System.out.println("Entrez la donnée n°"+ i +" tableau");
            tab[i-1] = lectureClavier.nextInt();      
        }
        
        for (int j=0;j<x;j++){
            System.out.print(tab[j]+" ,");
        }
        
        
        
    }
    
}
