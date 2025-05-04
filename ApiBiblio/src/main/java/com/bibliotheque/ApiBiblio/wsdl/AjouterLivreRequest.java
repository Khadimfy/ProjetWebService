package com.bibliotheque.ApiBiblio.wsdl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "titre",
    "auteur"
})
@XmlRootElement(name = "AjouterLivreRequest", namespace = "http://www.bibliotheque.com/wsdl")
public class AjouterLivreRequest {

    @XmlElement(namespace = "http://www.bibliotheque.com/wsdl", required = true)
    private String titre;

    @XmlElement(namespace = "http://www.bibliotheque.com/wsdl", required = true)
    private String auteur;

    // Getters & Setters

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

	public String getNomUtilisateur() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTitreLivre() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDateReservation() {
		// TODO Auto-generated method stub
		return null;
	}
}
