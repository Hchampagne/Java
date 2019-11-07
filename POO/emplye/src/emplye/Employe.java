/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emplye;

/**
 * v1.00 07/11/2019 
 * @author 80010-92-01
 */

import java.util.Scanner;

public class Employe {
    
    public int nMatricule;
    public float dSalaire;
    public float augmentation;
    
    public float augnenteSalaire(){
        dSalaire += augmentation;
        return dSalaire;       
    }
    
    public static void main(String args[]){
        
        float dSal = 0;
        
        Employe e1 = new Employe();
        
        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("Entrez le matricule");
        e1.nMatricule = lectureClavier.nextInt();
        
        System.out.println("Entrez le salaire");
        e1.dSalaire = lectureClavier.nextFloat();
        
        System.out.println("Entrez l'augmentation");
        e1.augmentation = lectureClavier.nextFloat();
             
        dSal = e1.augnenteSalaire();
        System.out.println("Matricule :" + e1.nMatricule +" => Salaire :"+ dSal);        
    }   
}
