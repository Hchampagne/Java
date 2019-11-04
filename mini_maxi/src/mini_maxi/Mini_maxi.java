/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini_maxi;

import java.util.Scanner;

/**
 *
 * @author 80010-92-01
 */
public class Mini_maxi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        float nB ; 
        int x=0;
        float somme = 0;
        float moyenne;
        float max;
        float mini;
                                  
        Scanner lectureClavier = new Scanner(System.in);        
        System.out.println("Entrez un nombre : ");
        nB = lectureClavier.nextFloat(); 
        
        mini = max  = nB ;
              
        while( nB != 0 ){ 
            
        x=x+1;
        somme = somme + nB;
        
        if(max < nB){max = nB;}
        if(mini > nB ){mini = nB;}
        
        System.out.println("Entrez un nombre : ");
        nB = lectureClavier.nextInt();            
        }
        
        moyenne = somme / (float)x;
        
        System.out.println("somme : "+somme);
        System.out.println("nb : "+x);
        System.out.println("moyenne : "+moyenne);
        System.out.println ("mini :" + mini +" , maxi : "+max);
    }
    
}
