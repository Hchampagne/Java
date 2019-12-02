/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crud;

/**
 *
 * @author 80010-92-01
 */
public class Client {
    
    //public int cli_id;
    public int id;
    public String nom;
    public String prenom;
    public String adresse;
    public String ville;
    
    public Client(){
}
    public Client(int id, String n, String p, String a, String v){
        this.id = id;
        this.nom = n;
        this.prenom = p;
        this.adresse = a;
        this.ville = v;             
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
    
    

}
