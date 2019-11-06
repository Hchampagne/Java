/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcul;

import java.util.Scanner;

/**
 * v1.00 06/10/2019
 * @author 80010-92-01
 */
public class Calcul {

    
    public static void main(String[] args) {
        double n1;
        double n2;
        String operateur;
        
        Scanner lectureClavier = new Scanner(System.in);
        
        System.out.print("nombre 1 : ");
        n1 = lectureClavier.nextDouble();
        System.out.print("nombre 2 : ");
        n2 = lectureClavier.nextDouble();
        System.out.print("chooix opérateur : ");
        lectureClavier.nextLine();
        operateur = lectureClavier.nextLine();
        
        switch(operateur){
            case "+" :
                System.out.println("Résultat = "+plus(n1,n2));
                break;
                
            case "-" :
                System.out.println("Résultat = "+moins(n1,n2));
                break;
            
            case "*" :
                System.out.println("Résultat = "+mult(n1,n2));
                break;
                
            case "/" :
                System.out.println("Résultat = "+div(n1,n2));
                break;
                
            default :
                System.out.println("Operateur incorrecte !");
                break;           
        }       
    }
    
    public static double plus( double x1,double x2){
        double result = x1 + x2;
        return result;
    } 
    
    public static double moins( double x1,double x2){
        double result = x1 - x2;
        return result;
    }  
   
    public static double mult( double x1,double x2){
        double result = x1 * x2;
        return result;
    }
    
    public static double div( double x1,double x2){
        double result = x1 / x2;
        return result;
    }  
}
    

