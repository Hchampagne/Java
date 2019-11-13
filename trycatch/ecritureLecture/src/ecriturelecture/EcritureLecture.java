/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecriturelecture;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 80010-92-01
 */
public class EcritureLecture {

    
    public static void main(String[] args) {
        try 
        {	
            List<String> lignes = new ArrayList<String>();	
            lignes.add("lorem");	
            lignes.add("ipsum");	
            Files.write(Paths.get("c:/test/test5.txt"), lignes, StandardOpenOption.CREATE_NEW );	
	
        }	
        catch (IOException e) 
        {	
            System.out.println("Un probleme est survenu pendant l'écriture du fichier");	
        }
        
        	
        try 
        {	
            List<String> lignes = Files.readAllLines(Paths.get("c:/test/test5.txt"));	
            for (String l : lignes) {	
            System.out.println(l);	
        }	
        }	
        catch (Exception e) 
        {	
        System.out.println("Un probleme est survenu pendant la lecture du fichier");	
        }
    }  
}
