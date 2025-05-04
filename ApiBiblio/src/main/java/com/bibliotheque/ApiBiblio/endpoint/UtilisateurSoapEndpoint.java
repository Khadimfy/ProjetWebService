package com.bibliotheque.ApiBiblio.endpoint;

import com.bibliotheque.ApiBiblio.model.Utilisateur;
import com.bibliotheque.ApiBiblio.service.UtilisateurService;
import com.bibliotheque.ApiBiblio.wsdl.AjouterUtilisateurRequest;
import com.bibliotheque.ApiBiblio.wsdl.AjouterUtilisateurResponse;
import com.bibliotheque.ApiBiblio.wsdl.UtilisateurType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UtilisateurSoapEndpoint {

    private static final String NAMESPACE_URI = "http://www.bibliotheque.com/wsdl";

    @Autowired
    private UtilisateurService utilisateurService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AjouterUtilisateurRequest")
    @ResponsePayload
    public AjouterUtilisateurResponse ajouterUtilisateur(@RequestPayload AjouterUtilisateurRequest request) {
        // Créer l'objet Utilisateur (entité JPA)
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(request.getNom());
        utilisateur.setPrenom(request.getPrenom());
        utilisateur.setEmail(request.getEmail());

        // Appel au service avec vérification d'email
        utilisateurService.ajouterUtilisateur(utilisateur);

        // Construire l'objet UtilisateurType pour la réponse SOAP
        UtilisateurType utilisateurType = new UtilisateurType();
        utilisateurType.setId(utilisateur.getId());
        utilisateurType.setNom(utilisateur.getNom());
        utilisateurType.setPrenom(utilisateur.getPrenom());
        utilisateurType.setEmail(utilisateur.getEmail());

        // Créer et retourner la réponse
        AjouterUtilisateurResponse response = new AjouterUtilisateurResponse();
        response.setUtilisateur(utilisateurType);

        return response;
    }
}
