/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cercle;

/**
 * v1.00 07/11/2019
 * @author 80010-92-01
 */
public class DesCercles {
    
     public static void main(String[] args) {
        
        double c = 0;
        double s = 0;  
        
        Cercle c1 = new Cercle();
        c1.rayon = 10;
        c = c1.circonference();
        s = c1.surface();
        System.out.println("Rayon : "+ c1.rayon +"  Circonférence : " + c + "  surface : " + s);
        
        Cercle c2 = new Cercle();
        c2.rayon = 45;
        c = c2.circonference();
        s = c2.surface();
        System.out.println("Rayon : "+ c2.rayon +"  Circonférence : " + c + "  surface : " + s);
    }
}
