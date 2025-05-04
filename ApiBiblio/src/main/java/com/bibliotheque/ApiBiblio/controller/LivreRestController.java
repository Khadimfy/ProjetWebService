package com.bibliotheque.ApiBiblio.controller;

import com.bibliotheque.ApiBiblio.model.Livre;
import com.bibliotheque.ApiBiblio.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livres")
public class LivreRestController {

    @Autowired
    private LivreService livreService;

    // Récupérer tous les livres
    @GetMapping
    public List<Livre> getAllLivres() {
        return livreService.findAll();
    }

    // Récupérer un livre par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Livre> getLivreById(@PathVariable Long id) {
        Optional<Livre> livre = livreService.findById(id);
        return livre.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Récupérer les livres disponibles
    @GetMapping("/disponibles")
    public List<Livre> getLivresDisponibles() {
        return livreService.findDisponiblesSansReservation();
    }
    // Ajouter un nouveau livre
    @PostMapping
    public Livre createLivre(@RequestBody Livre livre) {
        return livreService.save(livre);
    }

    // Modifier un livre existant
    @PutMapping("/{id}")
    public ResponseEntity<Livre> updateLivre(@PathVariable Long id, @RequestBody Livre livre) {
        Optional<Livre> existingLivre = livreService.findById(id);
        if (existingLivre.isPresent()) {
            livre.setId(id);  // Assure-toi que l'ID du livre est bien défini
            Livre updatedLivre = livreService.save(livre);
            return ResponseEntity.ok(updatedLivre);
        } else {
            return ResponseEntity.notFound().build(); // Si le livre n'est pas trouvé
        }
    }

    // Supprimer un livre par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivre(@PathVariable Long id) {
        Optional<Livre> livre = livreService.findById(id);
        if (livre.isPresent()) {
            livreService.delete(livre.get());
            return ResponseEntity.noContent().build();  // OK mais sans contenu à retourner
        } else {
            return ResponseEntity.notFound().build(); // Si le livre n'est pas trouvé
        }
    }
    @PutMapping("/{id}/emprunter")
    public ResponseEntity<Livre> emprunterLivre(@PathVariable Long id) {
        Optional<Livre> livreOptional = livreService.findById(id);
        if (livreOptional.isPresent()) {
            Livre livre = livreOptional.get();
            if (!livre.isDisponible()) {
                return ResponseEntity.badRequest().build(); // Livre déjà emprunté
            }
            livre.setDisponible(false);
            livreService.save(livre);
            return ResponseEntity.ok(livre);
        } else {
            return ResponseEntity.notFound().build(); // Livre non trouvé
        }
    }
    @PutMapping("/{id}/retourner")
    public ResponseEntity<Livre> retournerLivre(@PathVariable Long id) {
        Optional<Livre> livreOptional = livreService.findById(id);
        if (livreOptional.isPresent()) {
            Livre livre = livreOptional.get();
            if (livre.isDisponible()) {
                return ResponseEntity.badRequest().build(); // Déjà retourné
            }
            livre.setDisponible(true);
            livreService.save(livre);
            return ResponseEntity.ok(livre);
        } else {
            return ResponseEntity.notFound().build(); // Livre non trouvé
        }
    }
    

}
