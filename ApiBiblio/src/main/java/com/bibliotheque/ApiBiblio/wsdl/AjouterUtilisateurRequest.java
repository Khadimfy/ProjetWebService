package com.bibliotheque.ApiBiblio.wsdl;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "AjouterUtilisateurRequest", namespace = "http://www.bibliotheque.com/wsdl")
public class AjouterUtilisateurRequest {

    private String nom;
    private String prenom;
    private String email;

    @XmlElement(namespace = "http://www.bibliotheque.com/wsdl", required = true)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlElement(namespace = "http://www.bibliotheque.com/wsdl", required = true)
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @XmlElement(namespace = "http://www.bibliotheque.com/wsdl", required = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
