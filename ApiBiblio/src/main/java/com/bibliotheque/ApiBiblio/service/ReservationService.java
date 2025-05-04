package com.bibliotheque.ApiBiblio.service;

import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    public boolean ajouterReservation(String nomUtilisateur, String titreLivre, String dateReservation) {
        // Simule un enregistrement (à remplacer par la logique réelle avec la BDD)
        System.out.println("Ajout réservation : " + nomUtilisateur + " - " + titreLivre + " - " + dateReservation);
        return true;
    }

}
