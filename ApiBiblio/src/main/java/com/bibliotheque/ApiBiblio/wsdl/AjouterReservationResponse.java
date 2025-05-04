package com.bibliotheque.ApiBiblio.wsdl;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "AjouterReservationResponse", namespace = "http://bibliotheque.com/wsdl")
public class AjouterReservationResponse {

    @XmlElement(namespace = "http://bibliotheque.com/wsdl")
    private boolean success;

    @XmlElement(namespace = "http://bibliotheque.com/wsdl")
    private String message;

    // Getters et Setters
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	
		
	}
