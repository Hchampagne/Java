/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compte_age;

import java.util.Scanner;

/**
 *
 * @author 80010-92-01
 */
public class Compte_age {
 

    public static void main(String[] args){
       String  choix ;
       do{          
       int age;
       int jeune =0;
       int moyen = 0;
       int vieux = 0;
       
              
       Scanner lectureClavier = new Scanner(System.in);
       System.out.print("Entrez l'age : ");       
       age = lectureClavier.nextInt();
       
       while (age <100){
       
       if(age <20){jeune += 1; }
       if(age>=20 & age<=40){moyen += 1;}
       if(age>40){vieux += 1;}
       
       System.out.print("Entrez l'age : ");       
       age = lectureClavier.nextInt();       
       
       } 
       System.out.println("------------------");
       
       System.out.println("jeune(s) : " + jeune);  
       System.out.println("moyen(s) : " + moyen);  
       System.out.println("Vieux : " + vieux);
       System.out.println("Centenaire : 1");
       
       System.out.println("Voulez-vous continuer ? (o/n)");
       lectureClavier.nextLine();
       choix = lectureClavier.nextLine();
       }while(!"n".equals(choix));
        
    }
   
}