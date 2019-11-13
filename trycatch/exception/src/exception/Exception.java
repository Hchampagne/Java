/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 * v1.00 13/11/2019
 * @author 80010-92-01
 */
public class Exception {

   
    public static void main(String[] args) {
        
        int nX = 3;	
        int nY = 0;	
        try
        {
            System.out.print( nX + " / " + nY + " = ");	
            System.out.println(nX/nY); // !
        }
        catch(ArithmeticException e)
        {
            System.out.println("Erreur!");	
            System.out.println("Exception ArithmeticException interceptee ");	
            System.out.println(e);
        }
        System.out.println("Ouf,le programme n'est pas plante...");
    }
    
}
