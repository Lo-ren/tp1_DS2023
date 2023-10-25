package com.jpa.persistencia.repositorios;

import com.jpa.persistencia.entidades.EntidadBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface EntidadBaseRepository <E extends EntidadBase, ID extends Serializable> extends JpaRepository<E,ID> {
}
