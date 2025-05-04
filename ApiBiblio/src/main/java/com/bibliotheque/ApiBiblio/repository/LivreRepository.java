package com.bibliotheque.ApiBiblio.repository;

import com.bibliotheque.ApiBiblio.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivreRepository extends JpaRepository<Livre, Long> {
    // Récupérer les livres disponibles (disponible = true)
    List<Livre> findByDisponibleTrue();
}
