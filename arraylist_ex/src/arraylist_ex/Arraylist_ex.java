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
        
        String donnee;
        String prenom;
        String n ;
        String ajout;
        String nouv;
        String suppr;
        String modif;
        
        //creation tableau
        ArrayList<String> tab = new ArrayList<String>();
        
        boolean flag;
        
        // instanciation scanner pour entrée clavier
        Scanner lectureClavier = new Scanner(System.in);
        
        System.out.println("");
        System.out.println("---------------------------------");
        System.out.println("| 1 - Création du tableau       |");
        System.out.println("| 2 - ajout                     |");
        System.out.println("| 3 - modifier                  |");
        System.out.println("| 4 - supprimer                 |");
        System.out.println("| 5 - afficher                  |");
        System.out.println("| pour sortir exit              |");
        System.out.println("---------------------------------");
        System.out.println(""); 
        
        
        do{ //boucle pour menu
       
        System.out.print("entrez votre choix : "); // entrée choix       
        n =lectureClavier.nextLine();
        System.out.println("");
        System.out.println("*********************************");
        System.out.println("");
        
            switch(n){   //choix du menu
                case "1" :                      
                    // entrez des données ds tableau
                    System.out.println("Entrez les données");        
                    do{
                    System.out.print("Donnée : ");
                    donnee = lectureClavier.nextLine();
                    flag = !donnee.equals("exit");  //def  flag pour condition if et arret while
                    if (flag){tab.add(donnee);}  // entre dans tableau si diff exit 
                    }while(flag);  // sort sur exit saisi
                    break;
                
                case "2" :   
                    // ajout fin tableau
                    do{
                    System.out.print("Entrez le prenom à ajouter : "); //entre le prenom
                    prenom = lectureClavier.nextLine();              
                    tab.add(prenom);    //ajout au tableau
                    System.out.print("encore un ajout (o/n) ");
                    ajout = lectureClavier.nextLine();
                    }while(!ajout.equals("n"));
                    break;
                
                case "3":
                    //modifer une valeur
                    if(tab.size() != 0){
                        System.out.print("Entrez le prenom à modifier : "); //entre le prenom
                        modif= lectureClavier.nextLine(); 
                   
                        for (int i=0 ; i<=tab.size()-1 ; i++){  //modif valeur tableau
                            if(tab.get(i).equals(modif)){
                                System.out.print("Entrez le nouveau  prenom : ");
                                nouv = lectureClavier.nextLine(); 
                                tab.set(i,nouv);
                            }
                        } 
                    }else{
                        System.out.println("Tableau vide"); 
                    }
                    break;
                
                        
                case "4":    
                    //suppr du tableau
                    if(tab.size() != 0){
                        System.out.print("Entrez le prenom à supprimer : "); //entre le prenom
                        suppr = lectureClavier.nextLine();              
                        for (int i=0 ; i<=tab.size()-1 ; i++){  //supprimer le prenom
                            if(tab.get(i).equals(suppr)){
                                tab.remove(i);
                            }
                        }
                    }else{
                        System.out.println("Tableau vide");    
                    }
                    break;
                               
                case "5": 
                    // list tableau
                    for(String x : tab){
                        System.out.println( x + "," );                      
                    }                   
                    break;    
            
                default :
                    // si choix incorrecte
                    if(!n.equals("exit")){
                    System.out.println("choix incorrecte !");
                    }
                    break;
            }
              
        }while(!n.equals("exit"));  
        System.out.println("GOOD BYE !");
    }
    
}
