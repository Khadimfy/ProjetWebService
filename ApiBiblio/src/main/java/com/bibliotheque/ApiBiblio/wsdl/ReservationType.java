package com.bibliotheque.ApiBiblio.wsdl;

import java.time.LocalDate;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReservationType", propOrder = {
    "id",
    "dateDebut",
    "dateFin",
    "titreLivre",
    "nomUtilisateur"
})
public class ReservationType {

    @XmlElement(namespace = "http://www.bibliotheque.com/wsdl")
    private long id;

    @XmlElement(namespace = "http://www.bibliotheque.com/wsdl")
    private String dateDebut;

    @XmlElement(namespace = "http://www.bibliotheque.com/wsdl")
    private String dateFin;

    @XmlElement(namespace = "http://www.bibliotheque.com/wsdl")
    private String titreLivre;

    @XmlElement(namespace = "http://www.bibliotheque.com/wsdl")
    private String nomUtilisateur;

	public void setId(Object id2) {
		// TODO Auto-generated method stub
		
	}

	public void setDateDebut(String dateDebut2) {
		// TODO Auto-generated method stub
		
	}

	public void setDateFin(String dateFin2) {
		// TODO Auto-generated method stub
		
	}

	public void setTitreLivre(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setNomUtilisateur(String string) {
		// TODO Auto-generated method stub
		
	}

	public Object getTitreLivre() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getNomUtilisateur() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getDateDebut() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getDateFin() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDateDebut(LocalDate dateDebut2) {
		// TODO Auto-generated method stub
		
	}

	public void setDateFin(LocalDate dateFin2) {
		// TODO Auto-generated method stub
		
	}

    // Getters and Setters
}
