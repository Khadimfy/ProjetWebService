package com.bibliotheque.ApiBiblio.wsdl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "livre"
})
@XmlRootElement(name = "ModifierLivreResponse", namespace = "http://www.bibliotheque.com/wsdl")
public class ModifierLivreResponse {

    @XmlElement(name = "livre", namespace = "http://www.bibliotheque.com/wsdl", required = true)
    private LivreType livre;

    public LivreType getLivre() {
        return livre;
    }

    public void setLivre(LivreType livre) {
        this.livre = livre;
    }
}
