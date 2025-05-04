package com.bibliotheque.ApiBiblio.repository;

import com.bibliotheque.ApiBiblio.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    // Récupérer toutes les réservations pour un utilisateur donné
    List<Reservation> findByUtilisateurId(Long utilisateurId);

    // Récupérer les réservations d’un livre donné
    List<Reservation> findByLivreId(Long livreId);

    // Optionnel : trouver les réservations actives à une date donnée
    List<Reservation> findByDateDebutBeforeAndDateFinAfter(java.time.LocalDate date1, java.time.LocalDate date2);
}
