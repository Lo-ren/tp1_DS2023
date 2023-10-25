package com.jpa.persistencia.repositorios;

import com.jpa.persistencia.entidades.Factura;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends EntidadBaseRepository<Factura,Long> {
}