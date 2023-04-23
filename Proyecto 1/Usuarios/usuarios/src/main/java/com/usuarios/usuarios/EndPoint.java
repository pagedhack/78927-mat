package com.usuarios.usuarios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.clientes.BusquedaUsuarioIDRequest;
import https.t4is_uv_mx.clientes.BusquedaUsuarioIDResponse;
import https.t4is_uv_mx.clientes.BusquedaUsuarioNombreRequest;
import https.t4is_uv_mx.clientes.BusquedaUsuarioNombreResponse;
import https.t4is_uv_mx.clientes.EliminarUsuarioRequest;
import https.t4is_uv_mx.clientes.EliminarUsuarioResponse;
import https.t4is_uv_mx.clientes.ListaUsuariosResponse;
import https.t4is_uv_mx.clientes.ModificarUsuarioRequest;
import https.t4is_uv_mx.clientes.ModificarUsuarioResponse;
import https.t4is_uv_mx.clientes.RegistroRequest;
import https.t4is_uv_mx.clientes.RegistroResponse;

@Endpoint
public class EndPoint {

    Iterable<Clientes> listaClientes;

    @Autowired
    private iClientes iclientes;

    @PayloadRoot(localPart = "RegistroRequest", namespace = "https://t4is.uv.mx/clientes")

    @ResponsePayload
    public RegistroResponse Registro(@RequestPayload RegistroRequest peticion) {
        RegistroResponse response = new RegistroResponse();

        if (peticion.getNombre() == "[string]" || peticion.getApellido() == "[string]"
                || peticion.getEmail() == "[string]" || peticion.getContrasena() == "[string]"
                || peticion.getDireccion() == "[string]" || peticion.getTelefono() == 0) {

            response.setRespuesta("Completa los Campos");

        } else {
            Clientes cliente = new Clientes();
            cliente.setNombre(peticion.getNombre());
            cliente.setApellido(peticion.getApellido());
            cliente.setEmail(peticion.getEmail());
            cliente.setContraseña(peticion.getContrasena());
            cliente.setDireccion(peticion.getDireccion());
            cliente.setTelefono(peticion.getTelefono());
            iclientes.save(cliente);

            response.setRespuesta("Cliente Registrado");
        }

        return response;
    }



    @PayloadRoot(localPart = "BusquedaUsuarioIDRequest", namespace = "https://t4is.uv.mx/clientes")

    @ResponsePayload
    public BusquedaUsuarioIDResponse buscarId(@RequestPayload BusquedaUsuarioIDRequest peticion) {
        BusquedaUsuarioIDResponse response = new BusquedaUsuarioIDResponse();
        Optional<Clientes> c = iclientes.findById(peticion.getId());
        Clientes cl = c.get();
        response.setRespuesta(
                "\n" + "Cliente con id: " + peticion.getId()
                        + "\n" + "-Nombre: " + cl.getNombre()
                        + "\n" + "-Apellido:" + cl.getApellido()
                        + "\n" + "-Email: " + cl.getEmail()
                        + "\n" + "-Direccion: " + cl.getDireccion()
                        + "\n" + "-Telefono: " + cl.getTelefono());

        return response;
    }



    @PayloadRoot(localPart = "BusquedaUsuarioNombreRequest", namespace = "https://t4is.uv.mx/clientes")

    @ResponsePayload
    public BusquedaUsuarioNombreResponse buscarNombre(@RequestPayload BusquedaUsuarioNombreRequest peticion) {
        BusquedaUsuarioNombreResponse response = new BusquedaUsuarioNombreResponse();
        Optional<Clientes> c = iclientes.findByNombre(peticion.getNombre());
        Clientes cl = c.get();
        response.setRespuesta(
                "\n" + "Cliente con nombre: " + peticion.getNombre()
                        + "\n" + "-Nombre: " + cl.getNombre()
                        + "\n" + "-Apellido:" + cl.getApellido()
                        + "\n" + "-Email: " + cl.getEmail()
                        + "\n" + "-Contraseña: " + cl.getContraseña()
                        + "\n" + "-Direccion: " + cl.getDireccion()
                        + "\n" + "-Telefono: " + cl.getTelefono());

        return response;
    }



    @PayloadRoot(localPart = "ListaUsuariosRequest", namespace = "https://t4is.uv.mx/clientes")

    @ResponsePayload
    public ListaUsuariosResponse listar() {
        ListaUsuariosResponse response = new ListaUsuariosResponse();
        String Datos = "";
        listaClientes = iclientes.findAll();
        for (Clientes clientes : listaClientes) {
            Datos += "\n" + "Id: " + clientes.getId()
                    + "\n" + "Nombre: " + clientes.getNombre()
                    + "\n" + "Apellidos: " + clientes.getApellido()
                    + "\n" + "Email: " + clientes.getEmail()
                    + "\n" + "Direccion: " + clientes.getDireccion()
                    + "\n" + "Telefono: " + clientes.getTelefono()
                    + "\n";
        }
        response.setRespuesta(Datos);
        return response;
    }



    @PayloadRoot(localPart = "ModificarUsuarioRequest", namespace = "https://t4is.uv.mx/clientes")

    @ResponsePayload
    public ModificarUsuarioResponse modificar(@RequestPayload ModificarUsuarioRequest peticion) {
        String vacio = "[string]";
        ModificarUsuarioResponse response = new ModificarUsuarioResponse();
        Optional<Clientes> c = iclientes.findById(peticion.getId());
        Clientes cl = c.get();

            if (peticion.getNombreAModificar().equals(vacio)) {}
                else {
                    cl.setNombre(peticion.getNombreAModificar());
                    response.setRespuesta("se ha modificado el nombre");
                    iclientes.save(cl);
                    return response;
                }
                if (peticion.getApellidoAModificar().equals(vacio)) {} 
                else {
                    cl.setApellido(peticion.getApellidoAModificar());
                    response.setRespuesta("se ha modificado el apellido");
                    iclientes.save(cl);
                    return response;
                }
                if (peticion.getEmailAModificar().equals(vacio)) {} 
                else {
                    cl.setEmail(peticion.getEmailAModificar());
                    response.setRespuesta("se ha modificado el email");
                    iclientes.save(cl);
                    return response;
                }
                if (peticion.getContrasenaAModificar().equals(vacio)) {} 
                else {
                    cl.setContraseña(peticion.getContrasenaAModificar());
                    response.setRespuesta("se ha modificado la contraseña");
                    iclientes.save(cl);
                    return response;
                }
                if ((peticion.getDireccionAModificar().equals(vacio))) {} 
                else {
                    cl.setDireccion(peticion.getDireccionAModificar());
                    response.setRespuesta("se ha modificado la direccion");
                    iclientes.save(cl);
                }
                if (peticion.getTelefonoNuevo() == 0) {} 
                else {
                    cl.setTelefono(peticion.getTelefonoNuevo());
                    response.setRespuesta("se ha modificado el telefono");
                    iclientes.save(cl);
                }

        
        
        // response.setRespuesta("Usuario modificado");
        return response;
    }



    @PayloadRoot(localPart = "EliminarUsuarioRequest", namespace = "https://t4is.uv.mx/clientes")

    @ResponsePayload
    public EliminarUsuarioResponse eliminar(@RequestPayload EliminarUsuarioRequest peticion) {
        EliminarUsuarioResponse response = new EliminarUsuarioResponse();
        if (peticion.getId() == 0) {
            response.setRespuesta("No se puede eliminar un cliente que no existe");
        } else {
            iclientes.deleteById(peticion.getId());
            response.setRespuesta("Se ha eliminado el cliente con id: " + peticion.getId());
        }
        return response;
    }
}
