/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suite1;

/**
 *  v1.000 12/11/2019
 * @author 80010-92-01
 */
public class Suite1 {

   public abstract class Vehicule{
        public String Marche() 
        { 
            return " "; 
        }
    }

    public static class Avion extends Vehicule{
        private String carb;

        public Avion(String c)
            {
                carb = c;
            }

            public String Marche()
            {
                return carb;
            }
        }
    
    public static class Velo extends Vehicule{
        private String carb;

            public Velo(String c){
                carb = c;
            }

        public String Marche()
        {
            return carb;
        
        }
    } 
    
    public static class Bateau extends Vehicule{
        
        private String carb;
        
        public Bateau(String c)
        {
            carb = c;
        }
        
        public String Marche(){
            return carb;
        }
        
    }          
          
     public static class Camion extends Vehicule{
        private String carb;

            public Camion(String c){
                carb = c;
            }

        public String Marche(){
            return carb;
        
        }
    } 
    
    public static void main(String[] args){
        
        Vehicule[] Tableau = { new Avion("kérosène"), new Velo("mes jambes"), new Bateau("vapeur ou voile"), new Camion("la chose à Léon") };

        String s = "";

        for (Vehicule fo : Tableau){
            System.out.println(fo.Marche());
            s += fo.Marche()+","; 
        }
        System.out.println(s);

    }
}
        
    
    

