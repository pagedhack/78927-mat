package main.java.Aplicacion.Rest.repositories;

import main.java.Aplicacion.Rest.models.PedidosModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PedidoRepository extends CrudRepository<PedidosModel, Long> {

}
