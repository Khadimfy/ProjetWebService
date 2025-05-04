package com.bibliotheque.ApiBiblio.wsdl;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id"
})
@XmlRootElement(name = "RetournerLivreRequest", namespace = "http://www.bibliotheque.com/wsdl")
public class RetournerLivreRequest {

    @XmlElement(namespace = "http://www.bibliotheque.com/wsdl")
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
