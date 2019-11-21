/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tableview;

/**
 *
 * @author 80010-92-01
 */
public class Client {
    
    public String nom;
    public String prenom;
    public String ville;
    
    public Client(){
    }
    
    public Client(String nom, String prenom, String ville){
        this.nom = nom;
        this.prenom = prenom;
        this.ville = ville; 
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
    
    
    
}
