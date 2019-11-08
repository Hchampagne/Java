/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triconstr;

import java.util.Scanner;

/**
 *
 * @author 80010-92-01
 */
public class Triconstr {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        int taille;
        int titre;
                
        Scanner lClavier = new Scanner(System.in); 
               
        System.out.println("");
        
        System.out.print("Entrez la taille du tableau 1 : ");
        taille = lClavier.nextInt();
        titre = 1;
        nbconst t1 = new nbconst(taille,titre);  
        
        System.out.print("Entrez la taille du tableau 2 : ");
        taille = lClavier.nextInt();
        titre = 2;
        nbconst t2 = new nbconst(taille,titre); 
        
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
                    
        t1.affiche();   
        t2.affiche();       
    }
    }
    

