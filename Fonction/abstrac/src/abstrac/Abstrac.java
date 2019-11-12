/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstrac;

/**
 *
 * @author Doudou
 */
public class Abstrac {

    public abstract class Forme
    {
        public float Aire() 
        { 
            return 0; 
        }
    }

    public class Carre extends Forme
    {
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
    public class Cercle extends Forme
{
    private float rayon;

    public Cercle(float r)
    {
        rayon = r;
    }

    public float Aire()
    {
        return (float)(Math.PI * Math.pow(rayon, 2));
    }
}


    public static void main(String[] args) {
        // TODO code application logic here
        Forme[] Tableau = { new Carre(2), new Cercle(3), new Carre(5) };

float s = 0;

for (Forme fo : Tableau)
{
     s += fo.Aire(); 
}
System.out.println(s);

    }
    
}
