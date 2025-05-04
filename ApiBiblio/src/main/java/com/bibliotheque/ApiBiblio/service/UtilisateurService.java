package com.bibliotheque.ApiBiblio.service;

import com.bibliotheque.ApiBiblio.model.Utilisateur;
import com.bibliotheque.ApiBiblio.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    /**
     * Ajoute un utilisateur s'il n'existe pas déjà avec le même email.
     * @param utilisateur l'utilisateur à ajouter
     * @throws IllegalArgumentException si un utilisateur avec le même email existe déjà
     */
    public void ajouterUtilisateur(Utilisateur utilisateur) {
        Optional<Utilisateur> existant = utilisateurRepository.findByEmail(utilisateur.getEmail());
        if (existant.isPresent()) {
            throw new IllegalArgumentException("Un utilisateur avec cet email existe déjà.");
        }

        utilisateurRepository.save(utilisateur);
    }

    // (facultatif) Méthodes supplémentaires utiles

    public Optional<Utilisateur> getUtilisateurById(Long id) {
        return utilisateurRepository.findById(id);
    }

    public Iterable<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

	public Optional<Utilisateur> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
