/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suite;

/**
 * v1.00 06/10/2019
 * @author 80010-92-01
 */
public class Suite {

   
 static int nbr1=0;
 static int nbr2=1;  
 static int nbr3=0; 
 
 public static void main(String args[]){    
     int c = 10;   
     //print 0 and 1
     System.out.println(nbr1+" "+nbr2); 
     //deduire 2 car 0 et 1 sont deja affiches
     displayFibonacci(c-2);
 }  
  
 static void displayFibonacci(int c){    
    if(c > 0){    
         nbr3 = nbr1 + nbr2;    
         nbr1 = nbr2;    
         nbr2 = nbr3;    
         System.out.println(" "+nbr3);   
         displayFibonacci(c-1);    
     }    
 } 
  
 
    
}
