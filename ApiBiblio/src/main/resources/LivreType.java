package com.bibliotheque.ApiBiblio.wsdl;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LivreType", propOrder = {
    "id",
    "titre",
    "auteur",
    "disponible"
})
public class LivreType {

    @XmlElement(required = true)
    private Long id;

    @XmlElement(required = true)
    private String titre;

    @XmlElement(required = true)
    private String auteur;

    @XmlElement(required = true)
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

