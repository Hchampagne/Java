/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgabstract;

/**
 * v1.00 12/11/2019
 * @author 80010-92-01
 */
public class Abstract {

   public abstract class Forme{
        public float Aire() 
        { 
            return 0; 
        }
    }

    public static class Carre extends Forme{
        private float cote;

        public Carre(float c)
            {
                cote = c;
            }

            public float Aire()
            {
                return (float)Math.pow(cote, 2);
            }
        }
    
    public static class Cercle extends Forme{
        private float rayon;

            public Cercle(float r){
                rayon = r;
            }

        public float Aire(){
            return (float)(Math.PI * Math.pow(rayon, 2));
        
        }
    }   
    public static class Triangle extends Forme{
        private float hauteur;
        private float base;
        
        public Triangle(float h,float b){
            hauteur = h;
            base = b;
        }
        
        public float Aire(){
            return (float)hauteur*base/2;
        }
        
    }          
          
    
    
    public static void main(String[] args){
        
        Forme[] Tableau = { new Carre(2), new Cercle(3), new Carre(5), new Triangle(5 , 5) };

        float s = 0;

        for (Forme fo : Tableau){
            System.out.println(fo.Aire());
            s += fo.Aire(); 
        }
        System.out.println(s);

    }
}

