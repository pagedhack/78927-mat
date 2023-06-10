package com.pedidos.pedidos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

// import com.pedidos.pedidos.iPedidos;


@Endpoint
public class EndPoint {

    // @Autowired
    // private iPedidos ipedidos;

    // @PayloadRoot(localPart = "ListaPedidosRequest", namespace = "https://t4is.uv.mx/pedidos")

    // @ResponsePayload
    // public BusquedaUsuarioIDResponse buscarId(@RequestPayload BusquedaUsuarioIDRequest peticion) {
    //     BusquedaUsuarioIDResponse response = new BusquedaUsuarioIDResponse();
    //     BusquedaUsuarioIDResponse status = new BusquedaUsuarioIDResponse();
    //     Optional<Clientes> c = iclientes.findById(peticion.getId());
    //     Clientes cl = c.get();

    //     if (peticion.getId() == "[int]") {

    //         response.setResponse("411 Length Required");

    //     }
    //     response.setRespuesta(
    //             "\n" + "Cliente con id: " + peticion.getId()
    //                     + "\n" + "-Nombre: " + cl.getNombre()
    //                     + "\n" + "-Apellido:" + cl.getApellido()
    //                     + "\n" + "-Email: " + cl.getEmail()
    //                     + "\n" + "-Direccion: " + cl.getDireccion()
    //                     + "\n" + "-Telefono: " + cl.getTelefono());

    //     return response;
    // }

    // @PayloadRoot(localPart = "ListaUsuariosRequest", namespace = "https://t4is.uv.mx/clientes")

    // @ResponsePayload
    // public Iterable<ListaUsuariosResponse> usuarios(){
    // ListaUsuariosResponse x = new ListaUsuariosResponse();
    // Iterable<ListaUsuariosResponse> listaClientes = iclientes.findAll();
    // for(ListaUsuariosResponse)
    // }

    // @ResponsePayload
    // public ListaUsuariosResponse listar() {
    //     ListaUsuariosResponse response = new ListaUsuariosResponse();
    //     String Datos = "";
    //     listaClientes = iclientes.findAll();
    //     for (Clientes clientes : listaClientes) {
    //         Datos += "\n" + "Id: " + clientes.getId()
    //                 + "\n" + "Nombre: " + clientes.getNombre()
    //                 + "\n" + "Apellidos: " + clientes.getApellido()
    //                 + "\n" + "Email: " + clientes.getEmail()
    //                 + "\n" + "Direccion: " + clientes.getDireccion()
    //                 + "\n" + "Telefono: " + clientes.getTelefono()
    //                 + "\n";
    //     }
    //     response.setRespuesta(Datos);
    //     return response;
    // }
}
