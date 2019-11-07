/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strtok;

import java.util.Scanner;


/**
 * v1.00 06/10/2019
 * @author Doudou
 */
public class Strtok {
          
    public static void main(String[] args) {
        int pos;
        String ph ;
        String sep ;
        
        Scanner lectureClavier = new Scanner(System.in);
        
        System.out.print("Saisir la position du mot : ");
        pos = lectureClavier.nextInt();
        
        lectureClavier.nextLine();    
        System.out.print("Saisir la phrase : ");
        ph = lectureClavier.nextLine();
        
        System.out.print("Saisir le caractere de separation : ");
        sep = lectureClavier.nextLine();
        
        strtok(ph,sep,pos);
                    
    }
    
    public static void strtok( String ph,String sep,int pos){
             
        String[] result = ph.split(sep);
        if(pos <= result.length){
            System.out.println(result[pos-1]); 
        }else{
            System.out.println("Pas de résultat "); 
        }   
    }
}
