/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package germain;

import java.util.Scanner;

/**
 *
 * @author demo
 */
public class Germain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n =5;
        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("Entrez un nombre:");
        n = lectureClavier.nextInt();
        System.out.println(n);
    }
    
}
