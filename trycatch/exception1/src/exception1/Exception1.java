/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception1;

/**
 * v1.00  13/11/2019 
 * @author 80010-92-01
 */

import java.util.*;

public class Exception1 {

    
    public static void main(String[] args) {
       Scanner clavier = new Scanner(System.in);
       boolean bSaisieOK;
       byte nX = 0;
       do
       {
           bSaisieOK = true;
           try
           {
               System.out.println("Saisissez un byte : ");
               nX = clavier.nextByte();          
           }
           catch(InputMismatchException e)                   
           {
               System.out.println(e.getMessage());
               bSaisieOK = false;          
           }       
       }while(bSaisieOK);
       System.out.print("Vous avez saisi le nombre ");	
       System.out.println(nX);
    }
}