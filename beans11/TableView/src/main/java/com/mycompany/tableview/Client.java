/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tableview;

/**
 *
 * @author 80010-92-01
 * 
 */

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

        
public class Client {
	
    private  StringProperty nom;	
    private  StringProperty prenom;	
    private  StringProperty ville;
	
    public Client(){
        //constructeur vide defaut
    }
	
	
    Client(String p, String n, String v) {
	
        this.prenom = new SimpleStringProperty(p);	
        this.nom = new SimpleStringProperty(n);	
        this.ville = new SimpleStringProperty(v);	
    }
	
    //Getters and Setters
	
    public String getNom() {	
        return nom.get();	
    }
		
    public void setNom(String nom) {	
        this.nom.set(nom);	
    }
		
    public String getPrenom() {	
        return prenom.get();	
    }	
	
    public void setPrenom(String prenom) {	
        this.prenom.set(prenom);	
    }
		
    public String getVille() {	
        return ville.get();	
    }
		
    public void setVille(String ville) {
        this.ville.set(ville);	
    }	
}