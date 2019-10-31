/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package age;

import java.util.Scanner;

/**
 *
 * @author 80010-92-01
 */
public class Age {

    public static void main(String[] args) {
        
         int nX;
         int age;
        
        System.out.print("Entrez votre année de naissance : ");
        Scanner lectureClavier = new Scanner(System.in);
        nX = lectureClavier.nextInt();
        
        age = 2019 - nX;
        System.out.println("Votre age : " + age + " an(s).");
        
        if(age < 18){
            System.out.println("Vous êtes mineur !");
        }else{
            System.out.println("Vous êtes majeur !");
        }
        
        
    }
    
}
