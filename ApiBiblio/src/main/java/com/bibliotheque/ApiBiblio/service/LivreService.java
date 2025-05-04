package com.bibliotheque.ApiBiblio.service;

import com.bibliotheque.ApiBiblio.model.Livre;
import com.bibliotheque.ApiBiblio.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LivreService {

    @Autowired
    private LivreRepository livreRepository;

    // Récupérer tous les livres
    public List<Livre> findAll() {
        return livreRepository.findAll();
    }

    // Récupérer un livre par son ID
    public Optional<Livre> findById(Long id) {
        return livreRepository.findById(id);
    }

    // Récupérer les livres disponibles
    public List<Livre> findDisponibles() {
        return livreRepository.findByDisponibleTrue();
    }

    // Sauvegarder un nouveau livre ou mettre à jour un livre existant
    public Livre save(Livre livre) {
        return livreRepository.save(livre);
    }

    // Mettre à jour un livre existant
    public Optional<Livre> update(Long id, Livre livre) {
        if (livreRepository.existsById(id)) {
            livre.setId(id); // Nous assignons l'ID existant au livre mis à jour
            return Optional.of(livreRepository.save(livre));
        }
        return Optional.empty(); // Si le livre n'existe pas
    }

    // Supprimer un livre
    public void delete(Livre livre) {
        livreRepository.delete(livre);
    }

    // Supprimer un livre par son ID
    public void deleteById(Long id) {
        livreRepository.deleteById(id);
    }
    //reservation 
    public List<Livre> findDisponiblesSansReservation() {
        List<Livre> tousLesLivres = livreRepository.findAll();
        List<Livre> disponibles = tousLesLivres.stream()
            .filter(Livre::isDisponible)
            .collect(Collectors.toList());
        return disponibles;
    }
    
}
