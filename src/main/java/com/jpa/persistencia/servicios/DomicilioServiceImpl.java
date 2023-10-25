package com.jpa.persistencia.servicios;

import com.jpa.persistencia.entidades.Domicilio;
import com.jpa.persistencia.repositorios.DomicilioRepository;
import com.jpa.persistencia.repositorios.EntidadBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomicilioServiceImpl extends EntidadBaseServiceImpl<Domicilio,Long> implements DomicilioService {
    @Autowired
    private DomicilioRepository domicilioRepository;
    public DomicilioServiceImpl(EntidadBaseRepository<Domicilio,Long> entidadBaseRepository){super(entidadBaseRepository);}
}
