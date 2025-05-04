package com.bibliotheque.ApiBiblio.controller;

import com.bibliotheque.ApiBiblio.model.Utilisateur;
import com.bibliotheque.ApiBiblio.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurRestController {

    @Autowired
    private UtilisateurService utilisateurService;

    @PostMapping("/ajouter")
    public ResponseEntity<?> ajouterUtilisateur(@RequestBody Utilisateur utilisateur) {
        try {
            utilisateurService.ajouterUtilisateur(utilisateur);
            return ResponseEntity.ok(utilisateur);
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .badRequest()
                    .body("Erreur : " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUtilisateur(@PathVariable Long id) {
        Optional<Utilisateur> utilisateur = utilisateurService.getUtilisateurById(id);
        return utilisateur
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<?> getAllUtilisateurs() {
        return ResponseEntity.ok(utilisateurService.getAllUtilisateurs());
    }
}
