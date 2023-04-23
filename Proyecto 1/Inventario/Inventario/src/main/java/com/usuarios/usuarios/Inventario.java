package com.usuarios.usuarios;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Inventario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nombre;
    private String cantidad;
    private String existencia;
    private int valor;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getCantidad() {
        return cantidad;
    }
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getExistencia() {
        return existencia;
    }
    public void setExistencia(String existencia) {
        this.existencia = existencia;
    }

    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }

}
