package com.jpa.persistencia.repositorios;

import com.jpa.persistencia.entidades.Cliente;
import com.jpa.persistencia.repositorios.EntidadBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends EntidadBaseRepository<Cliente, Long> {
    //Realizar querys
}
