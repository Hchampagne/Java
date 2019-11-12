/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * v1.00 12/11/2019
 * @author 80010-92-01
 */
public class Client {
        String nom;
        String prenom;
        String adresse;
        String ville;
               
    public Client()
    {
    }
    
    public  Client(String nom, String prenom, String adresse, String ville)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.ville = ville;
    }
    
    public static String toString(String nom,String prenom,String adresse,String ville)   
    {
        return nom+ "," + prenom + "," + adresse + "," +ville;   
    }
   
              
    public static void main(String[] args) {
        
        Scanner lectureClavier = new Scanner(System.in);
        
        int i=0;
        String nom ;
        String prenom ;
        String adresse;
        String ville;
        String choix;
        
        ArrayList tab = new ArrayList();
                   
        do{
        
        System.out.print("Saisir le nom : ");
        nom = lectureClavier.nextLine();
        
        System.out.print("Saisir le prenom : ");
        prenom = lectureClavier.nextLine();
        
        System.out.print("Saisir l'adresse : ");
        adresse = lectureClavier.nextLine();
        
        System.out.print("Saisir la ville : ");
        ville = lectureClavier.nextLine();
        
        tab.add(Client.toString(nom,prenom,adresse,ville));
        
        System.out.print("Pour sortir 'exit' :");
        choix = lectureClavier.nextLine();
        
        }while(!choix.equals("exit")); 
        
        tab.forEach((x) -> {
            System.out.println( x + "," );
            });  
    }
}
