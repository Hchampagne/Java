/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moyenne;

import java.util.Scanner;

/**
 *
 * @author 80010-92-01
 */
public class Moyenne {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        float dS;       
        float iE;
        float tP;
        float moyenne;
        
        Scanner lectureClavier = new Scanner(System.in); 
        System.out.print("Entrez la note de devoir surveillé : ");
        dS = lectureClavier.nextFloat();
        System.out.print("Entrez la note de l'interr0 écrite : ");
        iE = lectureClavier.nextFloat();
        System.out.print("Entrez la note de TP : ");
        tP = lectureClavier.nextFloat();
        
        moyenne = ((dS*3f)+(iE*2)+tP) / 6f;
        
        System.out.println("Moyenne = " + moyenne);
        
    }  
}
