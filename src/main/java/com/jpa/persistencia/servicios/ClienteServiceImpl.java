package com.jpa.persistencia.servicios;

import com.jpa.persistencia.entidades.Cliente;
import com.jpa.persistencia.repositorios.ClienteRepository;
import com.jpa.persistencia.repositorios.EntidadBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ClienteServiceImpl extends EntidadBaseServiceImpl<Cliente,Long> implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    public ClienteServiceImpl(EntidadBaseRepository<Cliente,Long> entidadBaseRepository){super(entidadBaseRepository);}
}
