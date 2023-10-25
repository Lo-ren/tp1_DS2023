package com.jpa.persistencia.servicios;

import com.jpa.persistencia.entidades.Factura;
import com.jpa.persistencia.repositorios.EntidadBaseRepository;
import com.jpa.persistencia.repositorios.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaServiceImpl extends EntidadBaseServiceImpl<Factura,Long> implements FacturaService {
    @Autowired
    private FacturaRepository facturaRepository;
    public FacturaServiceImpl(EntidadBaseRepository<Factura,Long> entidadBaseRepository){super(entidadBaseRepository);}
}
