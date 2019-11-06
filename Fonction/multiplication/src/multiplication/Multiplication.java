/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplication;

import java.util.Scanner;

/**
 *  v 1.00 06/10/2019
 * @author 80010-92-01
 */
public class Multiplication {

  
    public static void main(String[] args) {
        
        int n ;
        Scanner lectureClavier = new Scanner(System.in);
        System.out.print("N° table : ");
        n = lectureClavier.nextInt();
        tableMulti(n);      
    }
    
    public static void  tableMulti(int x){
        
        for (int i = 1 ; i <= 10 ; i++){
            System.out.println(i + " * " + x + " = " + i*x );
        }
    }
}
