package com.bibliotheque.ApiBiblio.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relation avec Livre
    @ManyToOne
    @JoinColumn(name = "livre_id", nullable = false)
    private Livre livre;

    // Identifiant de l'utilisateur
    @Column(nullable = false)
    private Long utilisateurId;

    @Column(nullable = false)
    private LocalDate dateDebut;

    @Column(nullable = false)
    private LocalDate dateFin;

    // Nouveaux champs
    private LocalDate dateReservation;

    private boolean emprunte;

    public Reservation() {
    }

    public Reservation(Livre livre, Long utilisateurId, LocalDate dateDebut, LocalDate dateFin) {
        this.livre = livre;
        this.utilisateurId = utilisateurId;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.dateReservation = LocalDate.now();
        this.emprunte = false;
    }

    // --- Getters & Setters ---
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Long getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Long utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public LocalDate getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(LocalDate dateReservation) {
        this.dateReservation = dateReservation;
    }

    public boolean isEmprunte() {
        return emprunte;
    }

    public void setEmprunte(boolean emprunte) {
        this.emprunte = emprunte;
    }
}
