package com.bibliotheque.ApiBiblio.wsdl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ModifierLivreRequest", namespace = "http://www.bibliotheque.com/wsdl", propOrder = {
    "id",
    "titre",
    "auteur",
    "disponible"
})
@XmlRootElement(name = "ModifierLivreRequest", namespace = "http://www.bibliotheque.com/wsdl")
public class ModifierLivreRequest {

    @XmlElement(name = "id", namespace = "http://www.bibliotheque.com/wsdl", required = true)
    private Long id;

    @XmlElement(name = "titre", namespace = "http://www.bibliotheque.com/wsdl", required = true)
    private String titre;

    @XmlElement(name = "auteur", namespace = "http://www.bibliotheque.com/wsdl", required = true)
    private String auteur;
@XmlElement(name = "disponible", namespace = "http://www.bibliotheque.com/wsdl")
    private boolean disponible;

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}