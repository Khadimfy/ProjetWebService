package com.bibliotheque.ApiBiblio.controller;

import com.bibliotheque.ApiBiblio.model.Reservation;
import com.bibliotheque.ApiBiblio.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservations")
public class ReservationRestController {

    @Autowired
    private ReservationService reservationService;

    // GET /reservations → liste de toutes les réservations
    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.findAll();
    }

    // GET /reservations/{id} → réservation par ID
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        Optional<Reservation> reservation = reservationService.findById(id);
        return reservation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST /reservations → ajouter une réservation
    @PostMapping
    public ResponseEntity<String> createReservation(@RequestBody Reservation reservation) {
        Reservation saved = reservationService.save(reservation);
        return ResponseEntity.ok("Réservation enregistrée avec succès (ID: " + saved.getId() + ")");
    }
}
