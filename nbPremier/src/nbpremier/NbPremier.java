/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nbpremier;

import java.util.Scanner;

/**
 *
 * @author Doudou
 */
public class NbPremier {

    
    public static void main(String[] args) {

        String choix = "o";
        
        do{
                
        int nombre;
        boolean test = true;
                        
        Scanner lectureClavier = new Scanner(System.in); 
        System.out.println("Entre un nombre :");
        nombre = lectureClavier.nextInt();
        
        if(nombre != 0 && nombre != 1 && nombre!= 2){
        for(int i=2 ; i<nombre ; i++){
            if(nombre%i == 0){
                test = false;
            }
            }
            if (test == false){
                System.out.println(nombre+" n'est pas premier" );
            }else{
                System.out.println(nombre+" est premier" );
            }
            }
            else if(nombre == 0 ||nombre == 1){ System.out.println(nombre + " n'est pas premier" );}
            else {System.out.println(nombre + " est premier" );}
                      
            System.out.println("----------------------");
            System.out.println("Testez un autre nombre (o/n) ? ");
            lectureClavier.nextLine();
            choix = lectureClavier.nextLine();
        
        }while(!"n".equals(choix)); 
    }  
}
