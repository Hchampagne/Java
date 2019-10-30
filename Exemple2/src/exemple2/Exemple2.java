/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemple2;

/**
 *
 * @author 80010-92-01
 */
public class Exemple2 {
        final static double PI = 3.1416;

    public static void main(String[] args) {
        double rayon;
        double perimetre;
        
        System.out.println("Entrez le rayon : ");
        rayon = Console.lireD();
        perimetre = 2 * PI *rayon;
        System.out.print("Le perimùetre vaut : ");
        System.out.println(perimetre);
    }
    
}
