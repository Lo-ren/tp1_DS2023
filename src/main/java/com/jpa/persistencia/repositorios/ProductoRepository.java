package com.jpa.persistencia.repositorios;

import com.jpa.persistencia.entidades.Producto;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends EntidadBaseRepository<Producto,Long> {
}
