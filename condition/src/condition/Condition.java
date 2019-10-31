/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package condition;
import java.util.Scanner;

/**
 *
 * @author 80010-92-01
 */
public class Condition {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int nX;
        
        System.out.print("Entrez un nombre entier : ");
        Scanner lectureClavier = new Scanner(System.in);
        nX = lectureClavier.nextInt();
        
        if (nX%2 == 0){
            System.out.println(" Le nombre est paire");
        }else{
            System.out.println(" Le nombre est impaire");
    }
  }  
}
