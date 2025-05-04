package com.bibliotheque.ApiBiblio.wsdl;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id"
})
@XmlRootElement(name = "SupprimerLivreRequest", namespace = "http://www.bibliotheque.com/wsdl")
public class SupprimerLivreRequest {

    @XmlElement(namespace = "http://www.bibliotheque.com/wsdl")
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
