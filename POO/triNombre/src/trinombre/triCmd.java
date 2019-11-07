/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trinombre;

import java.util.Scanner;

/**
 * v1.00 07/11/2019
 * @author Doudou
 */
public class triCmd {
    
      public static void main(String[] args){
        int taille;
        int titre;
        Scanner lClavier = new Scanner(System.in); 
                        
        TriNombre t1 = new TriNombre();
        TriNombre t2 = new TriNombre();
        
        System.out.println("");
        System.out.print("Entrez la taille du tableau 1 : ");
        taille = lClavier.nextInt();
        t1.taille = taille;        
        System.out.print("Entrez la taille du tableau 2 : ");
        taille = lClavier.nextInt();
        t2.taille = taille;
        System.out.println("***********************************");
                
        System.out.println("");
        
        
        System.out.println("Tableau 1 : ");     
        t1.saisie();
        System.out.println("***********************************");
        System.out.println("");
        System.out.println("Tableau 2 : "); 
        t2.saisie(); 
        System.out.println("***********************************");
        System.out.println("");
        
        t1.trie();
        t2.trie();
        
        t1.titre=1;          
        t1.affiche();
        t2.titre=2;
        t2.affiche();       
    }
}
