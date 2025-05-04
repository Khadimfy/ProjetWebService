package com.bibliotheque.ApiBiblio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String auteur;
    private boolean disponible;

    public Livre() {
    }

    public Livre(String titre, String auteur, boolean disponible) {
        this.titre = titre;
        this.auteur = auteur;
        this.disponible = disponible;
    }

    // --- Getters & Setters ---

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
