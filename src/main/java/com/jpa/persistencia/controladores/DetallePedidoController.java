package com.jpa.persistencia.controladores;

import com.jpa.persistencia.entidades.DetallePedido;
import com.jpa.persistencia.servicios.DetallePedidoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/detallespedidos")
public class DetallePedidoController extends EntidadBaseControllerImpl<DetallePedido, DetallePedidoServiceImpl>{
}
