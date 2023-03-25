package mx.uv.practica04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.saludos.ASaludarRequest;
import https.t4is_uv_mx.saludos.ASaludarResponse;

@Endpoint
public class EndPoint {

    @Autowired
    private iSaludador isaludador;


    @PayloadRoot(localPart = "ASaludarRequest", namespace = "https://t4is.uv.mx/saludos")

    @ResponsePayload
    public ASaludarResponse Saludar(@RequestPayload ASaludarRequest peticion) {
        ASaludarResponse response = new ASaludarResponse();
        response.setRespuesta("Hola " + peticion.getNombre());

        Saludador saludador = new Saludador();
        saludador.setNombre(peticion.getNombre());
        isaludador.save(saludador);

        return response;
    }
}