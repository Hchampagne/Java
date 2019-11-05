/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylist_ex;

/**
 * V1.00 du 05/11/2019
 * @author 80010-92-01
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Arraylist_ex {

   
    public static void main(String[] args) {
        
        String choix;
        String donnee;
        String prenom;
        boolean flag;
        
        Scanner lectureClavier = new Scanner(System.in);
        
        //creation tableau
        ArrayList<String> tab = new ArrayList<String>();
        
        // entrez des données ds tableau
        System.out.println("Entrez les données (exit pour sortir)");        
        do{
        System.out.print("Donnée : ");
        donnee = lectureClavier.nextLine();
        flag = !donnee.equals("exit");  //def  flag pour condition if et arret while
        if (flag){tab.add(donnee);}  // entre dans tableau si diff exit 
        }while(flag);  // sort sur exit saisi
        
        // list tableau
        for(String i : tab){
            System.out.print(i+" ," );
            System.out.println();
        }
        
        //modif du tableau
        System.out.print("Entrez le prenom"); //entre le prenom
        prenom = lectureClavier.nextLine();
              
        for (int i=0 ; i<tab.size()-1 ; i++){  //supprimer le prenom et ajoute vide à la fin
            if(tab.get(i).equals(prenom)){
                tab.remove(i);
                tab.add("v");
            }
        }
        
        // list tableau
        for(String i : tab){
            System.out.print(i+" ," );
        }
              
        
        
    }
    
}
