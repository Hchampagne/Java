/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remise;

import java.util.Scanner;

/**
 *
 * @author 80010-92-01
 */
public class Remise {

  
    public static void main(String[] args) {
        
        float pu;
        int qte;
        float tva = 1.2f;
        float total;
        float port;
        float remise;
        
          
        
        Scanner lectureClavier = new Scanner(System.in);
        
        System.out.print("Entrez le prix unitaire : ");
        pu = lectureClavier.nextInt();
        
        System.out.print("Entrez la quantité : ");
        qte = lectureClavier.nextInt();
        
        total = pu * qte * tva;
        port = total * 2f /100f; 
                
        System.out.println(total);
        System.out.println(port);
        
        if( total < 500f ){ port = total * 2f /100f; 
        if ( port < 6f ){ port = 6f; }
        else { }}
        else { port = 0f; } 
        
        if ( total>100f && total<200){ remise = (total * 5/100); total = total - remise; } 
        if (total > 200f){ remise = (total * 10/100); total = total - remise; } 
        
        System.out.println(port);
        System.out.println(total);
       
    }   
}
