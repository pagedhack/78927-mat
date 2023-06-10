package main.java.Aplicacion.Rest.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import main.java.Aplicacion.Rest.models.PedidosModel;
import main.java.Aplicacion.Rest.services.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    PedidoService pedidoService;

    @GetMapping()
    public ArrayList<PedidosModel> obtenerPedidos(){
        return pedidoService.obtenerPedidos();
    }

    @PostMapping()
    public PedidosModel guardarPedido(@RequestBody PedidosModel pedido) {
        return this.pedidoService.guargarPedido(pedido);
    }
}
