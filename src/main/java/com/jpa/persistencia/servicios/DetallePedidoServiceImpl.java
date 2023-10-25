package com.jpa.persistencia.servicios;

import com.jpa.persistencia.entidades.DetallePedido;
import com.jpa.persistencia.repositorios.DetallePedidoRepository;
import com.jpa.persistencia.repositorios.EntidadBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetallePedidoServiceImpl extends EntidadBaseServiceImpl<DetallePedido,Long> implements DetallePedidoService {
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;
    public DetallePedidoServiceImpl(EntidadBaseRepository<DetallePedido,Long> entidadBaseRepository){super(entidadBaseRepository);}
}
