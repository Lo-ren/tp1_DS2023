package com.jpa.persistencia.repositorios;

import com.jpa.persistencia.entidades.Pedido;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends EntidadBaseRepository<Pedido,Long> {
}
