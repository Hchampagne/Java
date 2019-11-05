/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tab_ex2;

import java.util.Scanner;

/**
 *
 * @author 80010-92-01
 */
public class Tab_ex2 {

    
    public static void main(String[] args) {
        
      String prenom;  
      String[] tab = {"toto","titi","chose","bidule","tintin","milou","machin"};
      
      Scanner lectureClavier = new Scanner(System.in);
      System.out.print("Saisissez le prenom : ");
      prenom = lectureClavier.nextLine();
      
      
    for(int i=0 ; i<tab.length ; i++){
        if (prenom.equals(tab[i])){
            for(int j=i ; j < tab.length-1 ; j++){
           tab[j] = tab[j+1];  
            }
        }
    }
      
    tab[tab.length-1] = "v";
      
    for (int k=0 ; k < tab.length ; k++) {
        System.out.print(tab[k] + " , ");
    }      
    }   
}
