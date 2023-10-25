package com.jpa.persistencia.servicios;

import com.jpa.persistencia.entidades.Rubro;
import com.jpa.persistencia.repositorios.EntidadBaseRepository;
import com.jpa.persistencia.repositorios.RubroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RubroServiceImpl extends EntidadBaseServiceImpl<Rubro,Long> implements RubroService {
    @Autowired
    private RubroRepository rubroRepository;
    public RubroServiceImpl(EntidadBaseRepository<Rubro,Long> entidadBaseRepository){super(entidadBaseRepository);}
}
