/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparaison;
import java.util.Scanner;
/**
 *
 * @author 80010-92-01
 */
public class Comparaison {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int nX = 7, nY = 11, nZ = 11 ;
        
        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("Entrez le nombre X");
        nX = lectureClavier.nextInt();      
               
        System.out.println(nX) ;	
        System.out.println(nY) ;	
        System.out.println(nX < nY) ;	
        System.out.println(nX > nZ) ;	
        System.out.println(nY <= nZ) ;	
        System.out.println(nX >= nY) ;	
        System.out.println(nY == nZ) ;	
        System.out.println(nX != nZ) ;
    }    
}
