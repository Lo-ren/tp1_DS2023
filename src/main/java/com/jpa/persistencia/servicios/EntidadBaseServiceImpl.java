package com.jpa.persistencia.servicios;

import com.jpa.persistencia.entidades.EntidadBase;
import com.jpa.persistencia.repositorios.EntidadBaseRepository;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class EntidadBaseServiceImpl<E extends EntidadBase, ID extends Serializable> implements EntidadBaseService<E, ID> {
    protected EntidadBaseRepository<E,ID> entidadBaseRepository;

    public EntidadBaseServiceImpl(EntidadBaseRepository<E, ID> entidadBaseRepository) {
        this.entidadBaseRepository = entidadBaseRepository;
    }
    @Override
    @Transactional
    public List<E> findAll() throws Exception {

        try {
            List<E> entities = entidadBaseRepository.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E findById(ID id) throws Exception {
        try{
            Optional<E> entityOptional = entidadBaseRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E save(E entity) throws Exception {
        try{
            entity = entidadBaseRepository.save(entity);
            return entity;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public E update(ID id, E entity) throws Exception {
        try{
            Optional<E> entityOptional = entidadBaseRepository.findById(id);
            E entityUpdate = entityOptional.get();
            entityUpdate = entidadBaseRepository.save(entity);
            return entityUpdate;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(ID id) throws Exception {
        try{
            if(entidadBaseRepository.existsById(id)){
                entidadBaseRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
