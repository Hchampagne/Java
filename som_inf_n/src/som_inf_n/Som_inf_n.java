/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package som_inf_n;

import java.util.Scanner;

/**
 *
 * @author 80010-92-01
 */
public class Som_inf_n {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int nB ; 
        int nX = 0;
        int somme = 0;
                       
        Scanner lectureClavier = new Scanner(System.in);        
        System.out.println("Entrez nombre : ");
        nB = lectureClavier.nextInt();
        
        for(nX=0 ; nX < nB; nX++){somme = somme + nX ;}
        System.out.println(somme);
    }
    
}
