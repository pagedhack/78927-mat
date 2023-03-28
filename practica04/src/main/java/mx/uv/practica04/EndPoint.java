package mx.uv.practica04;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import antlr.collections.List;
import https.t4is_uv_mx.saludos.ASaludarRequest;
import https.t4is_uv_mx.saludos.ASaludarResponse;
import https.t4is_uv_mx.saludos.BBuscarIdRequest;
import https.t4is_uv_mx.saludos.BBuscarIdResponse;
import https.t4is_uv_mx.saludos.BlistaResponse;
import https.t4is_uv_mx.saludos.CModificarRequest;
import https.t4is_uv_mx.saludos.CModificarResponse;
import https.t4is_uv_mx.saludos.DEliminarRequest;
import https.t4is_uv_mx.saludos.DEliminarResponse;

@Endpoint
public class EndPoint {

    Iterable<Saludador> listanombres;

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
    

    @PayloadRoot(localPart = "BBuscarIdRequest", namespace = "https://t4is.uv.mx/saludos")

    @ResponsePayload
    public BBuscarIdResponse BuscarId(@RequestPayload BBuscarIdRequest peticion) {
        BBuscarIdResponse response = new BBuscarIdResponse();
        Optional<Saludador> s = isaludador.findById(peticion.getId());
        Saludador x = s.get();
        response.setRespuesta("se ha pedido el id: " + peticion.getId() + "| Nombre: " + x.getNombre());
        return response;
    }


    @PayloadRoot(localPart = "BlistarRequest", namespace = "https://t4is.uv.mx/saludos")

    @ResponsePayload
    public BlistaResponse Blistar() {
        BlistaResponse response = new BlistaResponse();
        String nombres= "";
        listanombres = isaludador.findAll();
        for (Saludador s : listanombres) {
            nombres += s.getId() + " - " + s.getNombre() + " // ";
        }
        response.setRespuesta(nombres);
        return response;
    }


    @PayloadRoot(localPart = "CModificarRequest", namespace = "https://t4is.uv.mx/saludos")

    @ResponsePayload
    public CModificarResponse Editar(@RequestPayload CModificarRequest peticion){
        CModificarResponse response = new CModificarResponse();
        Optional<Saludador> s = isaludador.findById(peticion.getId());
        Saludador x = s.get();
        x.setNombre(peticion.getNombre());
        isaludador.save(x);
        response.setRespuesta("se ha modificado el nombre del saludador " + x.getNombre());
        return response;
    }

    @PayloadRoot(localPart = "DEliminarRequest", namespace = "https://t4is.uv.mx/saludos")

    @ResponsePayload
    public DEliminarResponse Eliminar(@RequestPayload DEliminarRequest peticion){
        DEliminarResponse response = new DEliminarResponse();
        isaludador.deleteById(peticion.getId());
        response.setRespuesta("se ha eliminado el id: "+ peticion.getId());
        return response;
    }
}