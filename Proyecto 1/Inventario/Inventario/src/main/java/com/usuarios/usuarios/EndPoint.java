package com.usuarios.usuarios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.inventario.InventarioRequest;
import https.t4is_uv_mx.inventario.InventarioResponse;
import https.t4is_uv_mx.inventario.InventarioIDRequest;
import https.t4is_uv_mx.inventario.InventarioIDResponse;
import https.t4is_uv_mx.inventario.BuescarNombreRequest;
import https.t4is_uv_mx.inventario.BuescarNombreResponse;
import https.t4is_uv_mx.inventario.BorrardeInventarioRequest;
import https.t4is_uv_mx.inventario.BorrardeInventarioResponse;
import https.t4is_uv_mx.inventario.ListaInventarioResponse;
import https.t4is_uv_mx.inventario.CambioInventarioRequest;
import https.t4is_uv_mx.inventario.CambioInventarioResponse;


@Endpoint
public class EndPoint {

    Iterable<Inventario> listaInventario;

    @Autowired
    private iInventario iInventario;

    @PayloadRoot(localPart = "InventarioRequest", namespace = "https://t4is.uv.mx/inventario")

    @ResponsePayload
    public InventarioResponse Registro(@RequestPayload InventarioRequest peticion) {
        InventarioResponse response = new InventarioResponse();

        if (peticion.getNombre() == "[string]" || peticion.getCantidad() == "[string]"
                || peticion.getExistencia() == "[string]" || peticion.getValor() == 0) {

            response.setRespuesta("Completa los Campos");

        } else {
            Inventario inventario = new Inventario();
            inventario.setNombre(peticion.getNombre());
            inventario.setCantidad(peticion.getCantidad());
            inventario.setExistencia(peticion.getExistencia());
            inventario.setValor(peticion.getValor());
            iInventario.save(inventario);

            response.setRespuesta("Producto Agregado");
        }

        return response;
    }



    @PayloadRoot(localPart = "InventarioIDRequest", namespace = "https://t4is.uv.mx/inventario")

    @ResponsePayload
    public InventarioIDResponse buscarId(@RequestPayload InventarioIDRequest peticion) {
        InventarioIDResponse response = new InventarioIDResponse();
        Optional<Inventario> c = iInventario.findById(peticion.getId());
        Inventario cl = c.get();
        response.setRespuesta(
                "\n" + "Cliente con id: " + peticion.getId()
                        + "\n" + "-Nombre: " + cl.getNombre()
                        + "\n" + "-Cantidad:" + cl.getCantidad()
                        + "\n" + "-Existencia: " + cl.getExistencia()
                        + "\n" + "-Valor: " + cl.getValor());

        return response;
    }



    @PayloadRoot(localPart = "BuescarNombreRequest", namespace = "https://t4is.uv.mx/inventario")

    @ResponsePayload
    public BuescarNombreResponse buscarNombre(@RequestPayload BuescarNombreRequest peticion) {
        BuescarNombreResponse response = new BuescarNombreResponse();
        Optional<Inventario> c = iInventario.findByNombre(peticion.getNombre());
        Inventario cl = c.get();
        response.setRespuesta(
                "\n" + "Cliente con nombre: " + peticion.getNombre()
                        + "\n" + "-Nombre: " + cl.getNombre()
                        + "\n" + "-Cantidad:" + cl.getCantidad()
                        + "\n" + "-Existencia: " + cl.getExistencia()
                        + "\n" + "-Valor: " + cl.getValor());

        return response;
    }



    @PayloadRoot(localPart = "ListaInventarioRequest", namespace = "https://t4is.uv.mx/inventario")

    @ResponsePayload
    public ListaInventarioResponse listar() {
        ListaInventarioResponse response = new ListaInventarioResponse();
        String Datos = "";
        listaInventario = iInventario.findAll();
        for (Inventario inventario : listaInventario) {
            Datos += "\n" + "Id: " + inventario.getId()
                    + "\n" + "Nombre: " + inventario.getNombre()
                    + "\n" + "Cantidad: " + inventario.getCantidad()
                    + "\n" + "Valor: " + inventario.getValor()
                    + "\n";
        }
        response.setRespuesta(Datos);
        return response;
    }



    @PayloadRoot(localPart = "CambioInventarioRequest", namespace = "https://t4is.uv.mx/inventario")

    @ResponsePayload
    public CambioInventarioResponse modificar(@RequestPayload CambioInventarioRequest peticion) {
        String vacio = "[string]";
        CambioInventarioResponse response = new CambioInventarioResponse();
        Optional<Inventario> c = iInventario.findById(peticion.getId());
        Inventario cl = c.get();

            if (peticion.getCambiarNombre().equals(vacio)) {}
                else {
                    cl.setNombre(peticion.getCambiarNombre());
                    response.setRespuesta("se cambio el nombre");
                    iInventario.save(cl);
                    return response;
                }
                if (peticion.getModificarCantidad().equals(vacio)) {} 
                else {
                    cl.setCantidad(peticion.getModificarCantidad());
                    response.setRespuesta("se cambio la cantidad");
                    iInventario.save(cl);
                    return response;
                }
                if (peticion.getCambiarExistencia().equals(vacio)) {} 
                else {
                    cl.setExistencia(peticion.getCambiarExistencia());
                    response.setRespuesta("se cambio la existencia");
                    iInventario.save(cl);
                    return response;
                }
                if (peticion.getNuevoValor() == 0) {} 
                else {
                    cl.setValor(peticion.getNuevoValor());
                    response.setRespuesta("se cambio el valor");
                    iInventario.save(cl);
                }

        
        
        // response.setRespuesta("inventario modificado");
        return response;
    }



    @PayloadRoot(localPart = "BorrardeInventarioRequest", namespace = "https://t4is.uv.mx/inventario")

    @ResponsePayload
    public BorrardeInventarioResponse eliminar(@RequestPayload BorrardeInventarioRequest peticion) {
        BorrardeInventarioResponse response = new BorrardeInventarioResponse();
        if (peticion.getId() == 0) {
            response.setRespuesta("No se puede eliminar un producto que no existe");
        } else {
            iInventario.deleteById(peticion.getId());
            response.setRespuesta("Se ha eliminado el producto con id: " + peticion.getId());
        }
        return response;
    }
}
