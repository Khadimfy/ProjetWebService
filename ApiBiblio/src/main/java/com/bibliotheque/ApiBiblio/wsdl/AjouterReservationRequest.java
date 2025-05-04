package com.bibliotheque.ApiBiblio.wsdl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "AjouterReservationRequest", namespace = "http://bibliotheque.com/wsdl")
public class AjouterReservationRequest {

    @XmlElement(namespace = "http://bibliotheque.com/wsdl", required = true)
    private String nomUtilisateur;

    @XmlElement(namespace = "http://bibliotheque.com/wsdl", required = true)
    private String titreLivre;

    @XmlElement(namespace = "http://bibliotheque.com/wsdl", required = true)
    private String dateReservation;

    // ----- Getters & Setters -----
    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getTitreLivre() {
        return titreLivre;
    }

    public void setTitreLivre(String titreLivre) {
        this.titreLivre = titreLivre;
    }

    public String getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(String dateReservation) {
        this.dateReservation = dateReservation;
    }
}
