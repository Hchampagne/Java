/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package incrdecr;

/**
 *
 * @author 80010-92-01
 */
public class IncrDecr {

 
    public static void main(String[] args) {
        int nX = 8, nY = 13 ;
        int nZ = 0 ;
        System.out.println(nX) ;	
        System.out.println(nY) ;	
        System.out.println(++nX) ;	
        System.out.println(nY++) ;	
        System.out.println(nX) ;	
        System.out.println(nY) ;	
        nZ = ++nX ;	
        System.out.println(nZ) ;	
        nZ = nY++ ;	
        System.out.println(nZ) ;      
    }   
}
