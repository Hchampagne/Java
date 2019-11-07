/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trinombre;

/**
 * v1.00 07/11/2019
 * @author 80010-92-01
 */

import java.util.Scanner;

public class TriNombre {
        
    public int taille;
    int tab[] = new int[taille];
       
        public void saisie(){
            
           int donnee; 
            
           
           Scanner lClavier =new Scanner(System.in);
           System.out.print("Entrez taille du tableau : ");
           taille = lClavier.nextInt();          
           int tab[] = new int[taille];
         
           
           for (int i=0 ; i < taille ; i++){
               System.out.print("Entrez  donnée : ");
               donnee = lClavier.nextInt();
               tab[i] = donnee;
            }           
         
        }
    
        public void trie(){            
            int temp;
            for(int i=0;i<tab.length;i++){
                for(int j=1;j<tab.length-1;j++){
                    if(tab[j-1]>tab[j]){
                        temp = tab[j-1];
                        tab[j-1] = tab[j];
                        tab[j] = temp;
                    }
                }
            }   
        }
        
        public void affiche(){ 
            System.out.println("cc"); 
            for(int j=0 ; j < taille ; j++){
                System.out.println(tab[j]);
            }          
        }
        
    public static void main(String[] args) {
        
        TriNombre t1 = new TriNombre();
        
        //Scanner lClavier =new Scanner(System.in);
        //System.out.print("Entrez taille du tableau : ");
        //t1.taille = lClavier.nextInt(); 
        
       
        t1.saisie();
        t1.trie();
        t1.affiche();
        
        
        
    }
    
}
