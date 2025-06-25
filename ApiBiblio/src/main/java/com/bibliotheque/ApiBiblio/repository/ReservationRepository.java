package com.bibliotheque.ApiBiblio.repository;

import com.bibliotheque.ApiBiblio.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
