package com.bibliotheque.ApiBiblio.endpoint;

import com.bibliotheque.ApiBiblio.wsdl.AjouterLivreRequest;
import com.bibliotheque.ApiBiblio.wsdl.AjouterLivreResponse;
import com.bibliotheque.ApiBiblio.wsdl.LivreType;
import com.bibliotheque.ApiBiblio.wsdl.ModifierLivreRequest;
import com.bibliotheque.ApiBiblio.wsdl.ModifierLivreResponse;
import com.bibliotheque.ApiBiblio.wsdl.PreterLivreRequest;
import com.bibliotheque.ApiBiblio.wsdl.PreterLivreResponse;
import com.bibliotheque.ApiBiblio.wsdl.RetournerLivreRequest;
import com.bibliotheque.ApiBiblio.wsdl.RetournerLivreResponse;
import com.bibliotheque.ApiBiblio.wsdl.SupprimerLivreRequest;
import com.bibliotheque.ApiBiblio.wsdl.SupprimerLivreResponse;
import com.bibliotheque.ApiBiblio.model.Livre;
import com.bibliotheque.ApiBiblio.repository.LivreRepository;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.beans.factory.annotation.Autowired;

@Endpoint
public class LivreSoapEndpoint {

    private static final String NAMESPACE_URI = "http://www.bibliotheque.com/wsdl";

    @Autowired
    private LivreRepository livreRepository;

    // Ajouter un livre
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AjouterLivreRequest")
    @ResponsePayload
    public AjouterLivreResponse ajouterLivre(@RequestPayload AjouterLivreRequest request) {
        Livre livre = new Livre();
        livre.setTitre(request.getTitre());
        livre.setAuteur(request.getAuteur());
        livre.setDisponible(true);
        livreRepository.save(livre);
 // Préparer la réponse
        LivreType livreType = new LivreType();
        livreType.setId(livre.getId());
        livreType.setTitre(livre.getTitre());
        livreType.setAuteur(livre.getAuteur());
        livreType.setDisponible(livre.isDisponible());

        AjouterLivreResponse response = new AjouterLivreResponse();
        response.setLivre(livreType);

        return response;
    }

    // Modifier un livre
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ModifierLivreRequest")
    @ResponsePayload
    public ModifierLivreResponse modifierLivre(@RequestPayload ModifierLivreRequest request) {
        Livre livre = livreRepository.findById(request.getId()).orElse(null);

        if (livre != null) {
            livre.setTitre(request.getTitre());
            livre.setAuteur(request.getAuteur());
            livre.setDisponible(request.isDisponible());
            livreRepository.save(livre);
        }

        ModifierLivreResponse response = new ModifierLivreResponse();
        LivreType livreType = new LivreType();
        livreType.setId(livre.getId());
        livreType.setTitre(livre.getTitre());
        livreType.setAuteur(livre.getAuteur());
        livreType.setDisponible(livre.isDisponible());

        response.setLivre(livreType);
 return response;
    }

    // Supprimer un livre
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SupprimerLivreRequest")
    @ResponsePayload
    public SupprimerLivreResponse supprimerLivre(@RequestPayload SupprimerLivreRequest request) {
        livreRepository.deleteById(request.getId());

        SupprimerLivreResponse response = new SupprimerLivreResponse();
        response.setMessage("Livre supprimé avec succès");
        return response;
    }

    // Prêter un livre
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "PreterLivreRequest")
    @ResponsePayload
    public PreterLivreResponse preterLivre(@RequestPayload PreterLivreRequest request) {
        Livre livre = livreRepository.findById(request.getId()).orElse(null);

        if (livre != null && livre.isDisponible()) {
            livre.setDisponible(false);
            livreRepository.save(livre);
        }

        PreterLivreResponse response = new PreterLivreResponse();
        response.setMessage("Livre prêté avec succès");
        return response;
    }

    // Retourner un livre
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "RetournerLivreRequest")
    @ResponsePayload
    public RetournerLivreResponse retournerLivre(@RequestPayload RetournerLivreRequest request) {
 Livre livre = livreRepository.findById(request.getId()).orElse(null);

        if (livre != null) {
            livre.setDisponible(true);
            livreRepository.save(livre);
        }

        RetournerLivreResponse response = new RetournerLivreResponse();
        response.setMessage("Livre retourné avec succès");
        return response;
    }
}
