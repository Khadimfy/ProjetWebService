package com.bibliotheque.ApiBiblio.service;

import com.bibliotheque.ApiBiblio.model.Reservation;
import com.bibliotheque.ApiBiblio.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    // Récupérer toutes les réservations
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    // Récupérer une réservation par son ID
    public Optional<Reservation> findById(Long id) {
        return reservationRepository.findById(id);
    }

    // Sauvegarder une réservation (nouvelle ou mise à jour)
    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    // Mettre à jour une réservation existante
    public Optional<Reservation> update(Long id, Reservation updatedReservation) {
        if (reservationRepository.existsById(id)) {
            updatedReservation.setId(id); // Assigner l'ID existant
            return Optional.of(reservationRepository.save(updatedReservation));
        }
        return Optional.empty();
    }

    // Supprimer une réservation
    public void delete(Reservation reservation) {
        reservationRepository.delete(reservation);
    }

    // Supprimer une réservation par ID
    public void deleteById(Long id) {
        reservationRepository.deleteById(id);
    }
}
