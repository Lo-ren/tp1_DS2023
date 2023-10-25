package com.jpa.persistencia.servicios;

import com.jpa.persistencia.entidades.Producto;
import com.jpa.persistencia.repositorios.EntidadBaseRepository;
import com.jpa.persistencia.repositorios.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl extends EntidadBaseServiceImpl<Producto,Long> implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;
    public ProductoServiceImpl(EntidadBaseRepository<Producto,Long> entidadBaseRepository){super(entidadBaseRepository);}
}
