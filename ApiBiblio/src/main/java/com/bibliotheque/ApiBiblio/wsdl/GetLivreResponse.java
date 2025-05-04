package com.bibliotheque.ApiBiblio.wsdl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetLivreResponse", propOrder = {
    "livre"
})
@XmlRootElement(name = "GetLivreResponse")
public class GetLivreResponse {

    @XmlElement(required = true)
    private LivreType livre;

    // --- Getters & Setters ---
    public LivreType getLivre() {
        return livre;
    }

    public void setLivre(LivreType livre) {
        this.livre = livre;
    }
}
