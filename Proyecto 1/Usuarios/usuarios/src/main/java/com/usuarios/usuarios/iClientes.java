package com.usuarios.usuarios;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface iClientes extends CrudRepository <Clientes, Integer>{

    Optional<Clientes> findByNombre(String nombre);
    
}
