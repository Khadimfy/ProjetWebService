package com.bibliotheque.ApiBiblio.wsdl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AjouterUtilisateurResponse", propOrder = {
    "utilisateur"
})
@XmlRootElement(name = "AjouterUtilisateurResponse", namespace = "http://www.bibliotheque.com/wsdl")
public class AjouterUtilisateurResponse {

    @XmlElement(namespace = "http://www.bibliotheque.com/wsdl", required = true)
    private UtilisateurType utilisateur;

    // Getters and Setters
    public UtilisateurType getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UtilisateurType utilisateur) {
        this.utilisateur = utilisateur;
    }
}
