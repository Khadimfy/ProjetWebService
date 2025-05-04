package com.bibliotheque.ApiBiblio.endpoint;

import com.bibliotheque.ApiBiblio.wsdl.AjouterReservationRequest;
import com.bibliotheque.ApiBiblio.wsdl.AjouterReservationResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ReservationSoapEndpoint {

    private static final String NAMESPACE_URI = "http://bibliotheque.com/wsdl";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AjouterReservationRequest")
    @ResponsePayload
    public AjouterReservationResponse ajouterReservation(@RequestPayload AjouterReservationRequest request) {

        // Simuler un traitement (ici on ne fait rien avec le service)
        AjouterReservationResponse response = new AjouterReservationResponse();
        response.setSuccess(true);
        response.setMessage("Réservation reçue pour : " + request.getNomUtilisateur());

        return response;
    }
}
