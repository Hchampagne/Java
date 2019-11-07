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
public class Cercle {

        public double rayon;
        public double circonf;
        public double surf;
        
    public double circonference(){
        circonf = 2 * Math.PI * rayon;
        return circonf;
    }
    
    public double surface(){
        surf = Math.PI * Math.pow(rayon,2);
        return surf;
    }   
}
