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

   
        private StringProperty nom;
        private StringProperty prenom;
        private StringProperty ville; 
    
    
    public Client(){ 
    // constructeur vide defaut
    }
    
    Client(String n, String p, String v){
    // constructeur   
        this.prenom = new SimpleStringProperty(p);
        this.nom = new SimpleStringProperty(n);
        this.ville = new SimpleStringProperty(v);
    }

    public StringProperty getNom() {
        return nom;
    }

    public void setNom(String nom) {
        //this.nom = nom;
        this.nom.set(nom);
    }

    public StringProperty getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        //this.prenom = prenom;
        this.prenom.set(prenom);
    }

    public StringProperty getVille() {
        return ville;
    }

    public void setVille(String ville) {
        //this.ville = ville;
        this.ville.set(ville);
    }   
}