/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package som_interv;

import java.util.Scanner;

/**
 *
 * @author 80010-92-01
 */
public class Som_interv {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        int nB1 ;
        int nB2;
        int nX = 0;
        int somme = 0;
                       
        Scanner lectureClavier = new Scanner(System.in);        
        System.out.println("Entrez interval 1 : ");
        nB1 = lectureClavier.nextInt();
              
        System.out.println("Entrez interval 2 : ");
        nB2 = lectureClavier.nextInt();
                    
        for(nX=nB1 ; nX <= nB2; nX++){somme = somme + nX ;}
        System.out.println(somme);
    }
    
}
