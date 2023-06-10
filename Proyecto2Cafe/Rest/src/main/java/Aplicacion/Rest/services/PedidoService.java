package main.java.Aplicacion.Rest.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import main.java.Aplicacion.Rest.models.PedidosModel;
import main.java.Aplicacion.Rest.repositories.PedidoRepository;


public class PedidoService {
    @Autowired
    PedidoRepository pedidoRepository;

    public ArrayList<PedidosModel> obtenerPedidos() {
        return (ArrayList<PedidosModel>) pedidoRepository.findAll();
    }

    public PedidosModel guargarPedido(PedidosModel pedido) {
        return pedidoRepository.save(pedido);
    }
}
