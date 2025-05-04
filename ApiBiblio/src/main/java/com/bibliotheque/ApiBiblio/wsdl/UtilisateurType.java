package com.bibliotheque.ApiBiblio.wsdl;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "UtilisateurType", propOrder = {
    "id",
    "nom",
    "prenom",
    "email"
})
public class UtilisateurType {

    private Long id;
    private String nom;
    private String prenom;
    private String email;

    // Getters and Setters
    @XmlElement(required = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement(required = true)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @XmlElement(required = true)
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @XmlElement(required = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
