package com.usuarios.usuarios;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface iInventario extends CrudRepository <Inventario, Integer>{

    Optional<Inventario> findByNombre(String nombre);
    
}
