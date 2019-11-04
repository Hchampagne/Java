/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertion;

import java.util.Scanner;

/**
 *
 * @author 80010-92-01
 */
public class Convertion {

   
    public static void main(String[] args) {
        
        float nX;       
        float result;
        
        Scanner lectureClavier = new Scanner(System.in); 
        System.out.println("Entrez la température en °F ");
        nX = lectureClavier.nextFloat();  
        
        result =(nX - 32f) / (9f / 5f);        
        
        System.out.println("Résultat : " + result + " °c");
    }
    
}
