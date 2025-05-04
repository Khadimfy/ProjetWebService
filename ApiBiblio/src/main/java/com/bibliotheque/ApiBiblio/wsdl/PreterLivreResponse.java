package com.bibliotheque.ApiBiblio.wsdl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PreterLivreResponse", propOrder = {
    "message"
})
@XmlRootElement(name = "PreterLivreResponse")
public class PreterLivreResponse {

    @XmlElement(required = true)
    private String message;

    // --- Getters & Setters ---

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	public void setSuccess(boolean b) {
		// TODO Auto-generated method stub
		
	}
}

