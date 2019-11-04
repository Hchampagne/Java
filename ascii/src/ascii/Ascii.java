/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ascii;
import java.util.Scanner;
/**
 *
 * @author 80010-92-01
 */
public class Ascii {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        byte nX;    
        
        Scanner lectureClavier = new Scanner(System.in); 
        System.out.print("Entrez code caractère : ");
        nX = lectureClavier.nextByte(); 
       
        char car = (char)nX;
       
        System.out.println("resultat :" + car);
       
       
    }
    
}
