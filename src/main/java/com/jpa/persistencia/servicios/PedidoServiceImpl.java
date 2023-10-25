package com.jpa.persistencia.servicios;

import com.jpa.persistencia.entidades.Pedido;
import com.jpa.persistencia.repositorios.EntidadBaseRepository;
import com.jpa.persistencia.repositorios.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl extends EntidadBaseServiceImpl<Pedido,Long> implements PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;
    public PedidoServiceImpl(EntidadBaseRepository<Pedido,Long> entidadBaseRepository){super(entidadBaseRepository);}
}
