package com.jpa.persistencia.controladores;

import com.jpa.persistencia.entidades.Cliente;
import com.jpa.persistencia.servicios.ClienteServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = ".../v1/clientes")
public class ClienteController extends EntidadBaseControllerImpl<Cliente, ClienteServiceImpl>{
}
