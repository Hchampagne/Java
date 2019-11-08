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
public class nbconst {
    public int taille;
    public int tab[];
    public int titre;
    
        public nbconst(int taille,int titre){
            this.taille = taille;
            this.titre = titre;        
        }
        
        public void saisie(){ 
           tab = new int[taille];
           int donnee;          
           Scanner lClavier = new Scanner(System.in);                 
           for (int i=0 ; i < tab.length ; i++){
               System.out.print("Entrez  donnée : ");
               donnee = lClavier.nextInt();
               tab[i] = donnee;
            }          
        } 
    
        public void trie(){            
            int temp;
            for(int i=0;i<tab.length;i++){
                for(int j=1;j<tab.length;j++){
                    if(tab[j-1]>tab[j]){
                        temp = tab[j-1];
                        tab[j-1] = tab[j];
                        tab[j] = temp;
                    }
                }
            }   
        }
        
        public void affiche(){ 
            System.out.print("TABLEAU "+titre+" : ");
            for(int j=0 ; j < tab.length ; j++){               
                System.out.print(tab[j]+" ");                 
            }
            System.out.println("");
            System.out.println("***********************************");       
            System.out.println("");
        }
}
